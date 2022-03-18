package com.fengyq.leetcode;

public class SearchMatrix {
	/*编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
	每行的元素从左到右升序排列。
	每列的元素从上到下升序排列。
	示例:
	现有矩阵 matrix 如下：
	[
	  [1,   4,  7, 11, 15],
	  [2,   5,  8, 12, 19],
	  [3,   6,  9, 16, 22],
	  [10, 13, 14, 17, 24],
	  [18, 21, 23, 26, 30]
	]
	给定 target = 5，返回 true。
	给定 target = 20，返回 false。*/
	public static void main(String[] args) {
		int[][] matrix = {{1,   4,  7, 11, 15},
						  {2,   5,  8, 12, 19},
						  {3,   6,  9, 16, 22},
						  {10, 13, 14, 17, 24},
						  {18, 21, 23, 26, 30}};
		System.out.println(searchMatrix(matrix, 5));
	}
	
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		int searchCnt=0;
		if(matrix.length>0) {//沿对角线二分搜索
			searchCnt=Math.min(matrix.length, matrix[0].length);
		}
		boolean result = false;
		for (int i = 0; i < searchCnt; i++) {
			result=binarySearch(matrix, target, i, 1);
			if(result==true){
				return true;
			}
			result=binarySearch(matrix, target, i, 2);
			if(result==true){
				return true;
			}
		}
		return result;
	}

	private static boolean binarySearch(int[][] a, int target, int index, int flag) {
		int left=index;
		int right=0;
		int mid=0;
		if(flag==1) {//水平
			right=a[0].length-1;
			while(left<=right){
				mid=(left+right)/2;
				if(target<a[index][mid]){
					right=mid-1;
				}else if(target>a[index][mid]){
					left=mid+1;
				}else {
					return true;
				}
			}
		}else if(flag==2) {//垂直
			right=a.length-1;
			while(left<=right){
				mid=(left+right)/2;
				if(target<a[mid][index]){
					right=mid-1;
				}else if(target>a[mid][index]){
					left=mid+1;
				}else {
					return true;
				}
			}
		}
		return false;
	}
}
