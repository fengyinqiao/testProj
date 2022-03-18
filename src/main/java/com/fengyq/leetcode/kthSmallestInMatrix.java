package com.fengyq.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
//请注意，它是排序后的第k小元素，而不是第k个元素。
//示例:
//matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//返回 13。
public class kthSmallestInMatrix {
	public static int kthSmallest(int[][] matrix, int k) {
		Comparator cmp = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return (Integer)o2-(Integer)o1;
			}
		};
		PriorityQueue pq=new PriorityQueue(k, cmp);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				pq.add(matrix[i][j]);
				if(pq.size()>k) {
					pq.poll();
				}
			}
		}
		return (Integer)pq.peek();
    }
	
	public static void main(String[] args) {
		int[][] matrix={{ 1,  5,  9},
						{10, 11, 13},
						{12, 13, 15}};
		System.out.println(kthSmallest(matrix,9));
	}
}
