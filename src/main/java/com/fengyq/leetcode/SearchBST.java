package com.fengyq.leetcode;
//给定二叉搜索树:
//
//    4
//   / \
//  2   7
// / \
//1   3
//
//和值: 2
//你应该返回如下子树:
//
//  2     
// / \   
//1   3
public class SearchBST {
	public TreeNode searchBST(TreeNode root, int val) {
		if(root==null) {
			return null;
		}
		if(root.val==val) {
			return root;
		}
		if(val<root.val) {
			return searchBST(root.left,val);
		}
		if(val>root.val) {
			return searchBST(root.right,val);
		}
		return null;
	}
}
