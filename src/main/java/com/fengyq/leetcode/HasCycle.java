package com.fengyq.leetcode;

import java.util.HashSet;

public class HasCycle {
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
		System.out.println(hasCycle(l1));
		System.out.println(hasCycle2(l1));
	}
	public static boolean hasCycle(ListNode head) {
		if(head==null||head.next==null){
			return false;
		}
		ListNode slow=head;
		ListNode fast=head.next.next;
		while(slow!=fast){
			if(fast==null||fast.next==null) {
				return false;
			}
			slow=slow.next;
			fast=fast.next.next;
		}
		return true;
	}
	
	public static boolean hasCycle2(ListNode head) {
		HashSet<ListNode> hashSet=new HashSet<ListNode>();
		ListNode curr=head;
		while(curr!=null){
			if(hashSet.contains(curr)){
				return true;
			}else {
				hashSet.add(curr);
			}
			curr=curr.next;
		}
		return false;
	}
}
