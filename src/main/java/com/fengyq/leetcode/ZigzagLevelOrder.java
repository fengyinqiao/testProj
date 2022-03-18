package com.fengyq.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> lists=new ArrayList<List<Integer>>();
		if(root==null) {
			return lists;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int level=0;
		while(!queue.isEmpty()) {
			LinkedList<Integer> list=new LinkedList<Integer>();
			//当前层有多少元素
			int levelNums=queue.size();
			for (int i = 0; i < levelNums; i++) {
				TreeNode node=queue.poll();
				if(level%2==0) {
					list.add(node.val);
				}else {
					list.addFirst(node.val);
				}
				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
			}
			lists.add(list);
			level++;
		}
		return lists;
	}
	
	public static void main(String[] args) {
		ZigzagLevelOrder levelOrder=new ZigzagLevelOrder();
		TreeNode root=new TreeNode(3);
		TreeNode node1=new TreeNode(9);
		TreeNode node2=new TreeNode(20);
		TreeNode node3=new TreeNode(15);
		TreeNode node4=new TreeNode(7);
		root.left=node1;
		root.right=node2;
		node2.left=node3;
		node2.right=node4;
		
		List<List<Integer>> lists=levelOrder.zigzagLevelOrder(root);
		for (List<Integer> list : lists) {
			for (Integer integer : list) {
				System.out.print(integer+",");
			}
			System.out.println();
		}
	}
}
