package com.fengyq.leetcode;


public class BinarySearch {
	private static int recursionBinarySearch(int[] a,int key,int left,int right) {
		if(key<a[left]||key>a[right]||left>right){
			return -1;
		}
		
		int middle=(left+right)/2;
		if(key<a[middle]) {
			return recursionBinarySearch(a, key, left, middle-1);
		}else if(key>a[middle]) {
			return recursionBinarySearch(a, key, middle+1, right);
		}else {
			return middle;
		}
	}
	
	static private int commonBinarySearch(int[] a,int key) {
		int left=0;
		int right=a.length-1;
		int middle=0;
		if(key<a[left]||key>a[right]) {
			return -1;
		}
		while(left<=right){
			middle=(left+right)/2;
			if(key>a[middle]){
				left=middle+1;
			}else if(key<a[middle]){
				right=middle-1;
			}else {
				return middle;
			}
		}
		
		return -1;
	}
	
	public static boolean searchMatrix(int[][] matrix, int key) {
		int left=0,right=matrix.length*matrix[0].length-1,mid=0;
		int row=0,col=0;
		while(left<=right){
			mid=(left+right)/2;
			row=mid/matrix[0].length;
			col=mid%matrix[0].length;
			if(key<matrix[row][col]){
				right=mid-1;
			}else if(key>matrix[row][col]){
				left=mid+1;
			}else {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
//		int[] a={1,2,3,5,6,7,8,9};
//		System.out.println(recursionBinarySearch(a,4,0,a.length-1));
//		System.out.println(commonBinarySearch(a,4));
		
//		int[][] b={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
//		System.out.println(searchMatrix(b,30));
		
//		输入：1->2->4, 1->3->4
//		输出：1->1->2->3->4->4
		ListNode l1=new ListNode(1);
		ListNode n1=new ListNode(2);
		ListNode n2=new ListNode(4);
		ListNode n3=new ListNode(5);
		ListNode l2=new ListNode(1);
		ListNode m1=new ListNode(3);
		ListNode m2=new ListNode(4);
		l1.next=n1;
		n1.next=n2;
		n2.next=n3;
		l2.next=m1;
		m1.next=m2;
		ListNode newList=mergeTwoLists(l1,l2);
		ListNode curr=newList;
		while(curr!=null){
			System.out.println(curr.val);
			curr=curr.next;
		}

	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode curr1 = l1;
		while (curr1 != null) {
			ListNode next1 = curr1.next;
			ListNode curr2 = l2;
			while (curr2 != null) {
				ListNode next2 = curr2.next;
				if (curr1.val <= curr2.val) {
					curr1.next = curr2;
					l2 = curr1;
					break;
				} else if (next2 == null || curr1.val <= next2.val) {
					curr1.next = next2;
					curr2.next = curr1;
					break;
				}
				curr2 = next2;
			}
			curr1 = next1;
		}
		return l2;
	}
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
