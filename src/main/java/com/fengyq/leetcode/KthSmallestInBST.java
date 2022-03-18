package com.fengyq.leetcode;

import java.util.ArrayList;
import java.util.List;

//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
//说明：
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
//示例 1:
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1
//示例 2:
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3
//进阶：
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
public class KthSmallestInBST {
	public static int kthSmallest(TreeNode root, int k) {
		if(root==null) {
			return -1;
		}
		int leftCnt=findNodeCnt(root.left);
		if(leftCnt==k-1) {
			return root.val;
		}
		if(leftCnt<k-1) {
			return kthSmallest(root.right, k-leftCnt-1);
		}
		if(leftCnt>k-1) {
			return kthSmallest(root.left, k);
		}
		return -1;
	}
	private static int findNodeCnt(TreeNode root) {
		if(root==null) {
			return 0;
		}
		return 1+findNodeCnt(root.left)+findNodeCnt(root.right);
	}
	
	static List<Integer> list;
	public static int kthSmallest2(TreeNode root, int k) {
		list=new ArrayList<Integer>();
		inorderTraversalKthSmallest(root,k);
		return list.get(k-1);
	}
	
	static void inorderTraversalKthSmallest(TreeNode root,int k) {
		if(root==null) {
			return;
		}
		inorderTraversalKthSmallest(root.left,k);
		if(list.size()<k) {
			list.add(root.val);
		}
		inorderTraversalKthSmallest(root.right,k);
		return;
	}
	
	public static void main(String[] args) {
//		int[] nums={3,1,4,2};
		int[] nums={45,30,46,10,36,49,8,24,34,42,48,4,9,14,25,31,35,41,43,47,0,6,11,20,28,33,37,44,1,5,7,12,19,21,26,29,32,38,3,13,18,22,27,39,2,15,23,40,16,17};
//		int[] nums={5,3,6,2,4,1};
		TreeNode root=null;
		for (int i = 0; i < nums.length; i++) {
			root=InsertBST.insertIntoBST(root,nums[i]);
		}
		System.out.println(kthSmallest(root,32));
		System.out.println(kthSmallest2(root,32));
		System.out.println(list);
	}
}
