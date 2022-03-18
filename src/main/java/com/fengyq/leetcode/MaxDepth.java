package com.fengyq.leetcode;


public class MaxDepth {
//	给定二叉树 [3,9,20,null,null,15,7]
//	 	3
//	   / \
//	  9  20
//	    /  \
//	   15   7
//	返回它的最大深度 3 
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		TreeNode n1=new TreeNode(9);
		TreeNode n2=new TreeNode(20);
		TreeNode n3=new TreeNode(15);
		TreeNode n4=new TreeNode(7);
		root.left=n1;
		root.right=n2;
		n2.left=n3;
		n2.right=n4;
		System.out.println(maxDepth(root));
	}
	
	public static int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftDepth=maxDepth(root.left);
		int rightDepth=maxDepth(root.right);
		return Math.max(leftDepth, rightDepth)+1;
	}
	
}
