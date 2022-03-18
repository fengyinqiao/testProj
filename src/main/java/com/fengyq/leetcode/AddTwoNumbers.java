package com.fengyq.leetcode;


public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1=new ListNode(2);
		ListNode l11=new ListNode(4);
//		ListNode l12=new ListNode(3);
		ListNode l2=new ListNode(5);
		ListNode l21=new ListNode(6);
		ListNode l22=new ListNode(9);
		l1.next=l11;
//		l11.next=l12;
		l2.next=l21;
		l21.next=l22;
		ListNode newList=addTwoNumbers(l1,l2);
		ListNode curr=newList;
		while(curr!=null){
			System.out.println(curr.val);
			curr=curr.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
		//输出：7 -> 0 -> 8
		//原因：342 + 465 = 807
		//输入：(2 -> 4) + (5 -> 6 -> 9)
		//输出：7 -> 0 -> 0 -> 1
		//原因：42 + 965 = 1007
		ListNode curr1=l1;
		ListNode curr2=l2;
		ListNode curr3=new ListNode(0);
		ListNode result=curr3;
		int carry=0;
		while(!(curr1==null&&curr2==null)){
			int currVal1=0;
			int currVal2=0;
			if(curr1!=null) {
				currVal1=curr1.val;
				curr1=curr1.next;
			}
			if(curr2!=null) {
				currVal2=curr2.val;
				curr2=curr2.next;
			}
			int val=currVal1+currVal2+carry;
			carry=val/10;
			curr3.next=new ListNode(val%10);
			curr3=curr3.next;
		}
		if(carry!=0) {
			curr3.next=new ListNode(carry);
		}
		
		return result.next;
	}
}
