package com.fengyq.leetcode;

import java.util.HashMap;
import java.util.List;

public class BuildTree2 {
	// 中序遍历 inorder = [9,3,15,20,7]     左根右
	// 后序遍历 postorder = [9,15,7,20,3]	左右根
	// 返回如下的二叉树：
	// 3
	// / \
	// 9 20
	// / \
	// 15 7
	int postorderIdx;
	HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		postorderIdx = postorder.length - 1;
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		TreeNode node = build(postorder, 0, inorder.length - 1);
		return node;
	}

	private TreeNode build(int[] postorder, int inorderLeft, int inorderRight) {
		if (inorderLeft > inorderRight) {
			return null;
		}
		int rootVal = postorder[postorderIdx--];
		TreeNode root = new TreeNode(rootVal);
		int inorderIdx = inorderMap.get(rootVal);
		root.right = build(postorder, inorderIdx + 1, inorderRight);
		root.left = build(postorder, inorderLeft, inorderIdx - 1);
		return root;
	}

	public static void main(String[] args) {
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };
//		int[] inorder = { 2, 1, 4, 3, 5 };
//		int[] postorder = { 2, 4, 5, 3, 1 };
		TreeNode root = new BuildTree2().buildTree(inorder, postorder);

		List<List<Integer>> lists = new LevelOrder().levelOrder(root);
		for (List<Integer> list : lists) {
			for (Integer integer : list) {
				System.out.print(integer + ",");
			}
			System.out.println();
		}

	}
}
