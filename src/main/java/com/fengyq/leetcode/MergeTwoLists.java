package com.fengyq.leetcode;

public class MergeTwoLists {
	public static void main(String[] args) {
		// 输入：1->2->4, 1->3->4
		// 输出：1->1->2->3->4->4
		ListNode l1 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(5);
		ListNode l2 = new ListNode(1);
		ListNode m1 = new ListNode(3);
		ListNode m2 = new ListNode(4);
		l1.next = n1;
		n1.next = n2;
		n2.next = n3;
		l2.next = m1;
		m1.next = m2;
		ListNode newList = mergeTwoLists(l1, l2);
		ListNode curr = newList;
		while (curr != null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
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
