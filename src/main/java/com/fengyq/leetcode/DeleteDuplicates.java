package com.fengyq.leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class DeleteDuplicates {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l4;
		ListNode newList=deleteDuplicates2(l1);
		ListNode curr=newList;
		while(curr!=null){
			System.out.println(curr.val);
			curr=curr.next;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		//输入: 1->1->2->3->3
		//输出: 1->2->3
		ListNode curr=head;
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		while(curr!=null){
			if(!linkedHashSet.contains(String.valueOf(curr.val))){
				linkedHashSet.add(String.valueOf(curr.val));
			}
			curr=curr.next;
		}
		ListNode n=new ListNode(0);
		ListNode newHead=n;
		for (String string : linkedHashSet) {
			n.next=new ListNode(Integer.parseInt(string));
			n=n.next;
		}
		return newHead.next;
		
	}
	public static ListNode deleteDuplicates2(ListNode head) {
		//输入: 1->2->3->3->4->4->5
		//输出: 1->2->5
		ListNode curr=head;
		LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<String,Integer>();
		while(curr!=null){
			String str=String.valueOf(curr.val);
			int count=0;
			if(linkedHashMap.get(str)!=null) {
				count=linkedHashMap.get(str);
			}
			linkedHashMap.put(str, count+1);
			curr=curr.next;
		}
		ListNode n=new ListNode(0);
		ListNode newHead=n;
		for (Map.Entry<String,Integer> entry : linkedHashMap.entrySet()) {
			if(entry.getValue()==1){
				n.next=new ListNode(Integer.parseInt(entry.getKey()));
				n=n.next;
			}
		}
		return newHead.next;
		
	}
}
