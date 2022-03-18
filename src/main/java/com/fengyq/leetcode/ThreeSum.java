package com.fengyq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	/*
	 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0？
	 * 找出所有满足条件且不重复的三元组。
	 * 注意：答案中不可以包含重复的三元组。
	 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
	 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
	 *
	 * 解答
		1.这做这道题之前，我们先来简化一下，就是把三数之和，改成两数之和，也就是找出数组中所有满足 a + b = target 的组合。
		简化后的这道题该怎么做呢？我们可以这样做，先把数组进行排序，然后采用双指针的方法，从排序后的数组头尾两边向中间逼近，
		如果这两个数之和小于 target，则左边的指针向右移动，如果两个数之和大于 target，则右边指针向左移动
		2.①现在改成题目中的三数之和，即找出所有 a + b + c = 0的三元组，其实和二元组差不多，
			我们可以锁定一个数，然后把问题转换为两数之和，即找出 a + b = -c 的所有二元组，其中的 -c 相当于我们的 target
		  ②优化一下，如果nums[k] > 0的后，那 k 以及 k 后面的数都大于 0，此时不可能会出现 a + b +c = 0 的三元组。
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		List lists=new ArrayList<ArrayList<Integer>>();
		if(nums==null) {
			return lists;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			// 优化
			if(nums[i] > 0){
				break;
			}
			//去重
			if(i>0&&nums[i]==nums[i-1]) {
				continue;
			}
			int target = -nums[i];
			int left=i+1,right=nums.length-1;
			while(left<right) {
				if(nums[left]+nums[right]>target) {
					right--;
				}else if(nums[left]+nums[right]<target) {
					left++;
				}else {
					List list=new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					lists.add(list);
					while(left<right&&nums[left]==nums[left+1]) left++;//去重
					while(left<right&&nums[right]==nums[right-1]) right--;//去重
					left++;
					right--;
				}
			}
		}
		return lists;
	}

    public static void main(String[] args) {
		int[] nums={-1, 0, 1, 2, -1, -4};
		List<List<Integer>> lists=threeSum(nums);
		for (int i = 0; i < lists.size(); i++) {
			List<Integer> integers =  lists.get(i);
			for (int j = 0; j < integers.size(); j++) {
				Integer integer =  integers.get(j);
				System.out.print(integer+",");
			}
			System.out.println();
		}
    }
}
