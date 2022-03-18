package com.fengyq.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
//	给定二叉树: [3,9,20,null,null,15,7],
//	    3
//	   / \
//	  9  20
//	    /  \
//	   15   7
//	返回其层次遍历结果：
//	
//	[
//	  [3],
//	  [9,20],
//	  [15,7]
//	]
	/*
	1.首先把根节点加入队列。
	2.取出根节点，再查看根节点的左子树是是否存在，存在的话将左子树加入队列。同理，查看根节点的右子树是是否存在，存在的话将右子树加入队列。
	3.继续取出队列中的元素，由于队列先进先出的特性，在队列不空的情况下重复以上过程，就可以完成树的广度优先遍历。
	*/
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> lists=new ArrayList<List<Integer>>();
		if(root==null) {
			return lists;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			List<Integer> list=new ArrayList<Integer>();
			//当前层有多少元素
			int levelNums=queue.size();
			for (int i = 0; i < levelNums; i++) {
				TreeNode node=queue.poll();
				list.add(node.val);
				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
			}
			lists.add(list);
		}
		return lists;
    }
	
	static class ColorNode {
		TreeNode node;
		String color;
		int level;
		public ColorNode(TreeNode node,String color,int level) {
			this.node=node;
			this.color=color;
			this.level=level;
		}
	}
	
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> lists=new ArrayList<List<Integer>>();
		if(root==null) {
			return lists;
		}
		Queue<ColorNode> queue=new LinkedList<ColorNode>();
		queue.add(new ColorNode(root,"white",0));
		while(!queue.isEmpty()) {
			ColorNode colorNode=(ColorNode)queue.poll();
			if("white".equals(colorNode.color)) {
				queue.add(new ColorNode(colorNode.node,"gray",colorNode.level));
				if(colorNode.node.left!=null) {
					queue.add(new ColorNode(colorNode.node.left,"white",colorNode.level+1));
				}
				if(colorNode.node.right!=null) {
					queue.add(new ColorNode(colorNode.node.right,"white",colorNode.level+1));
				}
			}else {
				if(lists.size()==colorNode.level) {
					lists.add(new ArrayList<Integer>());
				}
				lists.get(colorNode.level).add(colorNode.node.val);
			}
		}
		return lists;
	}
	
	public static void main(String[] args) {
		LevelOrder levelOrder=new LevelOrder();
		TreeNode root=new TreeNode(3);
		TreeNode node1=new TreeNode(9);
		TreeNode node2=new TreeNode(20);
		TreeNode node3=new TreeNode(15);
		TreeNode node4=new TreeNode(7);
		root.left=node1;
		root.right=node2;
		node2.left=node3;
		node2.right=node4;
		
		List<List<Integer>> lists=levelOrder.levelOrder(root);
		for (List<Integer> list : lists) {
			for (Integer integer : list) {
				System.out.print(integer+",");
			}
			System.out.println();
		}
		
		lists=levelOrder.levelOrder2(root);
		for (List<Integer> list : lists) {
			for (Integer integer : list) {
				System.out.print(integer+",");
			}
			System.out.println();
		}
	}
}
