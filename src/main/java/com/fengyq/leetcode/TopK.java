package com.fengyq.leetcode;

import java.util.*;

/*
LC347. 前 K 个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]

示例 2:
输入: nums = [1], k = 1
输出: [1]
 */
public class TopK {
	public static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1,
					Map.Entry<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();//小根堆
			}
		};
		PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>(
				2, comparator);
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i],
					map.get(nums[i]) == null ? 1
							: (Integer) map.get(nums[i]) + 1);
		}
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			q.add(e);
			if (q.size() > k) {
				q.poll();
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		while (q.size()>0) {
			list.add(q.poll().getKey());
		}
		return list;
	}

	public static void main(String[] args){
		int[] nums = { 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5 };
		int k = 2;
		System.out.println(topKFrequent(nums, k));
	}
}