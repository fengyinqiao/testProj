package com.fengyq.leetcode;

public class LowestCommonAncestor {
	/*235. 二叉搜索树的最近公共祖先*/
	// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
	// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
	// 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
	// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
	//	输出: 3
	//	解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(5);
		root.right=new TreeNode(1);
		root.left.left=new TreeNode(6);
		root.left.right=new TreeNode(2);
		root.right.left=new TreeNode(0);
		root.right.right=new TreeNode(8);
		root.left.right.left=new TreeNode(7);
		root.left.right.right=new TreeNode(4);
		TreeNode p=new TreeNode(5);
		TreeNode q=new TreeNode(4);
		TreeNode lowestCommonAncestor=lowestCommonAncestor(root,p,q);
		System.out.println(lowestCommonAncestor.val);
		
	}
	//https://blog.csdn.net/qq_28114615/article/details/85715017
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null){
			return null;
		}
		if(root.val==p.val||root.val==q.val) {
			return root;
		}
		TreeNode left=lowestCommonAncestor(root.left, p, q);
		TreeNode right=lowestCommonAncestor(root.right, p, q);
		if(left!=null&&right!=null) {
			return root;
		}else if(left==null) {
			return right;
		}else if(right==null) {
			return left;
		}else {
			return null;
		}
	}
}
