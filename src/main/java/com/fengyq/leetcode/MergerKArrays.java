package com.fengyq.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergerKArrays {
	static class Node {
		int val;//数组值
		int row;//二维数组的第几行
		public Node(int val,int row) {
			this.val=val;
			this.row=row;
		}
	}
	public static int[] mergeKArrays(int[][] arrays) {//优先队列合并
		int[] ptr=new int[arrays.length];
		Arrays.fill(ptr, 0);
		Comparator<Node> comparator=new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.val-o2.val;
			}
		};
		PriorityQueue<Node> queue=new PriorityQueue<Node>(arrays.length, comparator);
		int nums=0;
		for (int i = 0; i < arrays.length; i++) {
			int p=ptr[i];//第i行的指针
			queue.add(new Node(arrays[i][p],i));
			ptr[i]=p+1;//第i行的指针向后挪
			nums=nums+arrays[i].length;
		}
		int[] res=new int[nums];
		int i=0;
		while(!queue.isEmpty()) {
			Node firstNode=queue.poll();
			res[i++]=firstNode.val;
			int row=firstNode.row;
			int p=ptr[row];
			if(p<arrays[row].length) {
				queue.add(new Node(arrays[row][p],row));
				ptr[row]=p+1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] arrays={{7,8,9},{1,2},{4,5,6},};
		int[] res=mergeKArrays(arrays);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}
	}
}
