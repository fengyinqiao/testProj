package com.fengyq.leetcode;

public class InsertBST {
//	给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和 插入的值: 5
//你可以返回这个二叉搜索树:
//
//         4
//       /   \
//      2     7
//     / \   /
//    1   3 5
	public static TreeNode insertIntoBST(TreeNode root, int val) {
		if(root==null) {
			return new TreeNode(val);
		}
		if(val<root.val) {
			root.left=insertIntoBST(root.left,val);
		}
		if(val>root.val) {
			root.right=insertIntoBST(root.right,val);
		}
		return root;
	}
	public static void main(String[] args) {
		
	}
}
