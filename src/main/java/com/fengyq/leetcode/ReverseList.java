package com.fengyq.leetcode;


public class ReverseList {
	// 输入: 1->2->3->4->5->NULL
	// 输出: 5->4->3->2->1->NULL
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		ListNode newList=reverseList(l1);
		ListNode curr=newList;
		while(curr!=null){
			System.out.println(curr.val);
			curr=curr.next;
		}
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev=null;
		ListNode curr=head;
		ListNode next=null;
		while(curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
