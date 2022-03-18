package com.fengyq.leetcode;

import java.util.HashSet;

public class DetectCycle {
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		l6.next=l4;
		ListNode newList=detectCycle(l1);
		ListNode curr=newList;
		while(curr!=null){
			System.out.println(curr.val);
			curr=curr.next;
		}
	}
	public static ListNode detectCycle(ListNode head) {
		HashSet<ListNode> hashSet=new HashSet<ListNode>();
		ListNode curr=head;
		while(curr!=null){
			if(hashSet.contains(curr)){
				return curr;
			}else {
				hashSet.add(curr);
			}
			curr=curr.next;
		}
		return null;
	}
}
