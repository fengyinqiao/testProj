package com.fengyq.leetcode;

import java.util.HashMap;
import java.util.List;

public class BuildTree {
//	例如，给出
//	前序遍历 preorder = [3,9,20,15,7] 根左右
//	中序遍历 inorder = [9,3,15,20,7]  左根右
//	返回如下的二叉树：
//	    3
//	   / \
//	  9  20
//	    /  \
//	   15   7
	int[] preorder;
	int[] inorder;
	int preIdx=0;
	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder=preorder;
		this.inorder=inorder;
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(0,inorder.length);
	}
	private TreeNode helper(int inorderLeft, int inorderRight) {
		if(preIdx==preorder.length||inorderLeft>=inorderRight) {
			return null;
		}
		int rootVal=preorder[preIdx];
		preIdx++;
		TreeNode root=new TreeNode(rootVal);
		int rootIdx=map.get(rootVal);
		root.left=helper(inorderLeft,rootIdx);
		root.right=helper(rootIdx+1,inorderRight);
		return root;
	}
	public static void main(String[] args) {
		int[] preorder ={3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode root=new BuildTree().buildTree(preorder, inorder);
		
		List<List<Integer>> lists=new LevelOrder().levelOrder(root);
		for (List<Integer> list : lists) {
			for (Integer integer : list) {
				System.out.print(integer+",");
			}
			System.out.println();
		}
	}
}
