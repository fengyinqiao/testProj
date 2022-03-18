package com.fengyq.leetcode;


//示例: 
//	给定如下二叉树，以及目标和 sum = 22，
//	              5
//	             / \
//	            4   8
//	           /   / \
//	          11  13  4
//	         /  \      \
//	        7    2      1
//	返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
public class HasPathSum {
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) {
			return false;
		}
		if(root.val==sum&&root.left==null&&root.right==null) {
			return true;
		}
		if(hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val)){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		TreeNode n1=new TreeNode(4);
		TreeNode n2=new TreeNode(8);
		TreeNode n3=new TreeNode(11);
		TreeNode n4=new TreeNode(13);
		TreeNode n5=new TreeNode(4);
		TreeNode n6=new TreeNode(7);
		TreeNode n7=new TreeNode(2);
		TreeNode n8=new TreeNode(1);
		root.left=n1;
		root.right=n2;
		n1.left=n3;
		n2.left=n4;
		n2.right=n5;
		n3.left=n6;
		n3.right=n7;
		n5.right=n8;
		System.out.println(hasPathSum(root,22));
	}
}
