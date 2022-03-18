package com.fengyq.leetcode;

public class IsValidBST_Unsettled {
	// 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
	// 输入:
	//  5
	// / \
	// 1 4
	//  / \
	//  3 6
	// 输出: false
	// 解释: 输入为: [5,1,4,null,null,3,6]。
	// 根节点的值为 5 ，但是其右子节点值为 4 。
	int max = Integer.MAX_VALUE;
	int min = Integer.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		if(root.left != null&&(root.left.val >= root.val || root.left.val >= max)) {
			return false;
		}
		if(root.left!=null) {
			max = root.left.val;
		}
		if(root.right != null&&(root.right.val <= root.val || root.right.val <= min)) {
			min = root.right.val;
			return false;
		}
		if(root.right!=null) {
			min = root.right.val;
		}
		return isValidBST(root.left) && isValidBST(root.right);
	}

	public static void main(String[] args) {
		
	}
}
