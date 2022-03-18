package com.fengyq.leetcode;

public class SearchInRotationArray {
//	假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//	( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//	搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//	你可以假设数组中不存在重复的元素。
//	你的算法时间复杂度必须是 O(log n) 级别。
//	示例 1:
//	输入: nums = [4,5,6,7,0,1,2], target = 0
//	输出: 4
//	示例 2:
//	输入: nums = [4,5,6,7,0,1,2], target = 3
//	输出: -1
	public int search2(int[] nums, int target) {
		if(nums==null||nums.length==0) {
			return -1;
		}
		int left=0,right=nums.length-1,mid=0;
		while(left<=right) {
			mid=left+(right-left)/2;
			if(target==nums[mid]) {
				return mid;
			}
			if(nums[mid]>=nums[left]) {//左边有序
				if(nums[left]<=target&&target<nums[mid]) {
					right=mid-1;
				}else{
					left=mid+1;
				}
			}else if(nums[mid]<nums[left]) {//右边有序
				if(nums[mid]<target&&target<=nums[right]) {
					left=mid+1;
				}else{
					right=mid-1;
				}
			}
		}
		return -1;
	}
	
	public int search(int[] nums, int target) {
		if(nums==null||nums.length==0) {
			return -1;
		}
		int idx=findRotateIdx(nums);
		int res=find(nums,0,idx-1,target);
		if(res!=-1) {
			return res;
		}
		return find(nums,idx,nums.length-1,target);
	}

	private int find(int[] nums,int left, int right,int target) {
		int mid=0;
		while(left<=right) {
			mid=left+(right-left)/2;
			if(target<nums[mid]) {
				right=mid-1;
			}else if(target>nums[mid]) {
				left=mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}

	private int findRotateIdx(int[] nums) {
		int left=0;
		int right=nums.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(mid+1>nums.length-1) {//防止mid+1数组越界
				return mid;
			}
			if(nums[mid]>nums[mid+1]) {//出现下降趋势，立即返回
				return mid+1;
			}else {
				if(nums[mid]<nums[left]) {//缩小右边界
					right=mid-1;	
				}else {
					left=mid+1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] nums={3,1};
		int target=1;
		System.out.println(new SearchInRotationArray().search2(nums, target));
	}
}
