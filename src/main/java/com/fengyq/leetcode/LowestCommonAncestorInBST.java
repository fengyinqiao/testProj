package com.fengyq.leetcode;
//输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
public class LowestCommonAncestorInBST {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null||p==null||q==null) {
			return null;
		}
		int max=Math.max(p.val, q.val);
		int min=Math.min(p.val, q.val);
		if(min<root.val&&root.val<max||root.val==max||root.val==min) {
			return root;
		}
		if(root.val>max) {
			return lowestCommonAncestor(root.left, p, q);
		}
		if(root.val<min) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return null;
    }
	
	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null||p==null||q==null) {
			return null;
		}
		if(root.val==p.val||root.val==q.val) {
			return root;
		}
		TreeNode left=lowestCommonAncestor(root.left, p, q);
		TreeNode right=lowestCommonAncestor(root.right, p, q);
		if(left!=null&&right!=null) {
			return root;
		}else if(left!=null&&right==null) {
			return left;
		}else if(left==null&&right!=null) {
			return right;
		}else {
			return null;
		}
    }
	
	public static void main(String[] args) {
		int[] nums = {6,2,8,0,4,7,9,3,5};
		int p = 2, q = 8;
		TreeNode root=null;
		for (int i = 0; i < nums.length; i++) {
			root=insertIntoBST(root, nums[i]);
		}
		TreeNode lca=lowestCommonAncestor(root,new TreeNode(p),new TreeNode(q));
		TreeNode lca2=lowestCommonAncestor2(root,new TreeNode(p),new TreeNode(q));
		System.out.println(lca.val);
		System.out.println(lca2.val);
	}
	
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
}
