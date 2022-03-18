package com.fengyq.leetcode;

public class IsSymmetric {
	//给定一个二叉树，检查它是否是镜像对称的。
	//
	//例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
	//
	//	  1
	//   / \
	//  2   2
	// / \ / \
	//3  4 4  3
	//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
	//
	//	  1
	//   / \
	//  2   2
	//   \   \
	//   3    3
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right.left=new TreeNode(4);
		root.right.right=new TreeNode(3);
		System.out.println(new IsSymmetric().isSymmetric(root));
	}
	
	public boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return true;
		}
		return isMirror(root.left,root.right);
	}
	
	private boolean isMirror(TreeNode n1,TreeNode n2) {
		if(n1==null&&n2==null) {
			return true;
		}
		if(n1==null||n2==null){
			return false;
		}
		
		if(n1.val==n2.val&&isMirror(n1.left,n2.right)&&isMirror(n1.right, n2.left)) {
			return true;
		}
		return false;
	}
}
