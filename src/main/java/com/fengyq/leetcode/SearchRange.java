package com.fengyq.leetcode;
/*LC34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。
示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
*/
public class SearchRange {
	public static int[] searchRange2(int[] nums, int target) {
		int[] result= {-1,-1};
		result[0]=searchLeftBound(nums,target);
		result[1]=searchRightBound(nums,target);
		return result;
	}
	
	public static int searchLeftBound(int[] nums, int target) {
		if(nums==null) {
			return -1;
		}
		int left=0,right=nums.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(target<nums[mid]) {
				right=mid-1;
			}else if(nums[mid]<target) {
				left=mid+1;
			}else if(target==nums[mid]) {
				right=mid-1;
			}
		}
		if(left<=nums.length-1 && nums[left]==target) {//左边界，所以判断left，因31行，left一直加，故判断left和length-1的关系
			return left;
		}else {
			return -1;
		}
	}
	
	public static int searchRightBound(int[] nums, int target) {
		if(nums==null) {
			return -1;
		}
		int left=0,right=nums.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(target<nums[mid]) {
				right=mid-1;
			}else if(nums[mid]<target) {
				left=mid+1;
			}else if(target==nums[mid]) {
				left=mid+1;
			}
		}
		if(0<=right && nums[right]==target) {//右边界，所以判断right，因51行，right一直减，故判断right和0的关系
			return right;
		}else {
			return -1;
		}
	}
	
	public static int[] searchRange(int[] nums, int target) {
		int[] result= {-1,-1};
		int idx=binarySearch(nums,0,nums.length-1,target);
		if(idx==-1) {
			return result;
		}
		int i=idx,j=idx;
		while(j>=0&&nums[j]==nums[idx]) {
			j--;
		}
		result[0]=j+1;
		while(i<=nums.length-1&&nums[i]==nums[idx]) {
			i++;
		}
		result[1]=i-1;
		return result;
	}

	private static int binarySearch(int[] nums, int left, int right, int target) {
		if(left>right||left<0||right>nums.length-1) {
			return -1;
		}
		int mid=right-(right-left)/2;
		if(target<nums[mid]) {
			return binarySearch(nums,left,mid-1,target);
		}else if(target>nums[mid]) {
			return binarySearch(nums,mid+1,right,target);
		}else {
			return mid;
		}
	}
	
	public static void main(String[] args) {
		int[] nums= {5,7,7,8,8,8,8,10};
		nums=searchRange2(nums,8);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
	}

}
