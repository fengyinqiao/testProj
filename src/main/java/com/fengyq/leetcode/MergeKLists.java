package com.fengyq.leetcode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MergeKLists {
	public static void main(String[] args) {
		// 输入：1->2->4, 1->3->4
		// 输出：1->1->2->3->4->4
		ListNode l1 = new ListNode(1);
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(5);
		ListNode l2 = new ListNode(1);
		ListNode m1 = new ListNode(3);
		ListNode m2 = new ListNode(4);
		ListNode l3 = new ListNode(2);
		ListNode x1 = new ListNode(6);
		l1.next = n1;
		n1.next = n2;
		l2.next = m1;
		m1.next = m2;
		l3.next = x1;
		ListNode[] lists=new ListNode[]{l1,l2,l3};
		ListNode newList=null;
//		for (int i = 0; i < lists.length;i++) {
//			newList = mergeTwoLists(newList, lists[i]);
//		}
		newList=mergeKLists(lists);
		ListNode curr = newList;
		while (curr != null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode newList=null;
		for (int i = 0; i < lists.length;i++) {
			ListNode curr1 = newList;
			ListNode curr2 = lists[i];
			ListNode curr3 = new ListNode(0);
			ListNode result = curr3;
			while (curr1 != null && curr2 != null) {
				if (curr1.val <= curr2.val) {
					curr3.next = curr1;
					curr1 = curr1.next;
					curr3 = curr3.next;
				} else {
					curr3.next = curr2;
					curr2 = curr2.next;
					curr3 = curr3.next;
				}
			}
			if (curr2 == null) {
				curr3.next = curr1;
			}
			if (curr1 == null) {
				curr3.next = curr2;
			}
			newList= result.next;
		}
		return newList;
	}
	
	public static ListNode mergeKLists2(ListNode[] lists) {//优先队列合并
		if (lists == null || lists.length == 0) return null;
		Comparator<ListNode> comparator=new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
		};
		PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(lists.length, comparator);
		for (int i = 0; i < lists.length; i++) {
			if(lists[i] != null) {
				queue.add(lists[i]);
			}
		}
		ListNode res=new ListNode(-1);
		ListNode curr=res;
		while(!queue.isEmpty()) {
			ListNode node=queue.poll();
			curr.next=node;
			curr=curr.next;
			if(node.next!=null) {
				queue.add(node.next);
			}
		}
		return res.next;
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode curr1 = l1;
		ListNode curr2 = l2;
		ListNode curr3 = new ListNode(0);
		ListNode result = curr3;
		while (curr1 != null && curr2 != null) {
			if (curr1.val <= curr2.val) {
				curr3.next = curr1;
				curr1 = curr1.next;
				curr3 = curr3.next;
			} else {
				curr3.next = curr2;
				curr2 = curr2.next;
				curr3 = curr3.next;
			}
		}
		if (curr2 == null) {
			curr3.next = curr1;
		}
		if (curr1 == null) {
			curr3.next = curr2;
		}
		return result.next;
	}

}
