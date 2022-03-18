package com.fengyq.leetcode;


public class MiddleNode {
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
		ListNode newList=middleNode(l1);
		ListNode curr=newList;
		while(curr!=null){
			System.out.println(curr.val);
			curr=curr.next;
		}
	}

	public static ListNode middleNode(ListNode head) {
		ListNode curr=head;
		int i=0;
		while(curr!=null) {
			i++;
			curr=curr.next;
		}
		int j=0;
		while(j<i/2&&head!=null){
			j++;
			head=head.next;
		}
		return head;
	}
}
