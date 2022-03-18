package com.fengyq.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OrderTraversal {
	//	输入: [1,null,2,3]  
	//    1
	//     \
	//      2
	//     /
	//    3 
	//
	// 输出: [3,2,1]
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		if(root==null) {
			return list;
		}
		list.addAll(postorderTraversal(root.left));
		list.addAll(postorderTraversal(root.right));
		list.add(root.val);
		return list;
	}
	
	//	输入: [1,null,2,3]  
	//    1
	//     \
	//      2
	//     /
	//    3 
	//
	// 输出: [1,3,2]
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		if(root==null) {
			return list;
		}
		list.addAll(inorderTraversal(root.left));
		list.add(root.val);
		list.addAll(inorderTraversal(root.right));
		return list;
	}
	
	static class ColorNode {
		TreeNode node;
		String color;
		public ColorNode(TreeNode node,String color) {
			this.node=node;
			this.color=color;
		}
	}
	
	public List<Integer> inorderTraversal2(TreeNode root) {//白色表示未访问过，灰色表示访问过
		Stack stack=new Stack();
		List<Integer> list= new ArrayList<Integer>();
		stack.push(new ColorNode(root, "white"));
		while(!stack.isEmpty()) {
			ColorNode colorNode=(ColorNode) stack.pop();
			if(colorNode.color.equals("white")) {
				if(colorNode.node.right!=null) {
					stack.push(new ColorNode(colorNode.node.right, "white"));
				}
				stack.push(new ColorNode(colorNode.node, "gray"));
				if(colorNode.node.left!=null) {
					stack.push(new ColorNode(colorNode.node.left, "white"));
				}
			}else {
				list.add(colorNode.node.val);
			}
		}
		return list;
	}
	
	//	输入: [1,null,2,3]  
	//    1
	//     \
	//      2
	//     /
	//    3 
	//
	// 输出: [1,2,3]
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		if(root==null) {
			return list;
		}
		list.add(root.val);
		list.addAll(preorderTraversal(root.left));
		list.addAll(preorderTraversal(root.right));
		return list;
	}
	public static void main(String[] args) {
		OrderTraversal orderTraversal=new OrderTraversal();
		TreeNode root=new TreeNode(1);
		TreeNode node1=null;
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		root.left=node1;
		root.right=node2;
		node2.left=node3;
		
		List<Integer> list=orderTraversal.preorderTraversal(root);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("");
		
		list=orderTraversal.inorderTraversal(root);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("");
		
		list=orderTraversal.postorderTraversal(root);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("");
	}
}
