package com.fengyq.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestIncreasingPath {
	/*
	 * 给定一个整数矩阵，找出最长递增路径的长度。
	 * 
	 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
	 * 
	 * 示例 1:
	 * 
	 * 输入: nums =[ [9,9,4], [6,6,8], [2,1,1] ] 输出: 4 解释: 最长递增路径为 [1, 2, 6, 9]。 输入:
	 * nums = [ [3,4,5], [3,2,6], [2,2,1] ] 输出: 4 解释: 最长递增路径是 [3, 4,
	 * 5,6]。注意不允许在对角线方向上移动。
	 */
	public static void main(String[] args) {
/*		int[][] matrix= {{9,9,4},
						 {6,6,8},
						 {2,1,1}};*/
//		int[][] matrix= {{1,2,3,4,5},{2,5,4,3,2},{3,6,5,1,2},{4,2,6,3,7},{5,3,5,6,8}};
//		int[][] matrix={};
		int[][] matrix = { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 19, 18, 17, 16, 15, 14, 13, 12, 11, 10 },
				{ 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 }, { 39, 38, 37, 36, 35, 34, 33, 32, 31, 30 },
				{ 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 }, { 59, 58, 57, 56, 55, 54, 53, 52, 51, 50 },
				{ 60, 61, 62, 63, 64, 65, 66, 67, 68, 69 }, { 79, 78, 77, 76, 75, 74, 73, 72, 71, 70 },
				{ 80, 81, 82, 83, 84, 85, 86, 87, 88, 89 }, { 99, 98, 97, 96, 95, 94, 93, 92, 91, 90 },
				{ 100, 101, 102, 103, 104, 105, 106, 107, 108, 109 },
				{ 119, 118, 117, 116, 115, 114, 113, 112, 111, 110 },
				{ 120, 121, 122, 123, 124, 125, 126, 127, 128, 129 },
				{ 139, 138, 137, 136, 135, 134, 133, 132, 131, 130 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		System.out.println(longestIncreasingPath(matrix));
		System.out.println(resultList);
		for (Map.Entry<String, List<Integer>> e : cacheMap.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
	}

	static List<Integer> resultList;
	//保存每个位置的结果，当再次访问到直接返回即可（记忆化搜索）
	static HashMap<String, List<Integer>> cacheMap;
	//四个方向，分别为右、下、左、上
	static final int[][] dirctions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static int longestIncreasingPath(int[][] matrix) {
		resultList = new ArrayList<Integer>();
		cacheMap = new HashMap<String, List<Integer>>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				List<Integer> tmpList = longestIncreasingPathHelper(matrix, i, j);
				if (tmpList.size() > resultList.size()) {
					resultList = tmpList;
				}
			}
		}
		return resultList.size();
	}

	private static List<Integer> longestIncreasingPathHelper(int[][] matrix, int i, int j) {
		if (cacheMap.containsKey("matrix[" + i + "][" + j + "]")) {
			return cacheMap.get("matrix[" + i + "][" + j + "]");
		}
		List<Integer> resultList = new ArrayList<Integer>();
		resultList.add(matrix[i][j]);
		List<Integer> maxList = new ArrayList<Integer>();
		List<Integer> tmpList = new ArrayList<Integer>();
		for (int[] dir : dirctions) {
			int x = i + dir[0], y = j + dir[1];
			if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[i].length && matrix[x][y] > matrix[i][j]) {
				tmpList = longestIncreasingPathHelper(matrix, x, y);
				if (tmpList.size() > maxList.size()) {
					maxList = tmpList;
				}
			}
		}
		resultList.addAll(maxList);
		cacheMap.put("matrix[" + i + "][" + j + "]", resultList);
		return resultList;
	}
}
