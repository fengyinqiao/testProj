package com.fengyq.leetcode;

public class SearchInRotationArray2 {
//	假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//	( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
//	编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
//	示例 1:
//	输入: nums = [2,5,6,0,0,1,2], target = 0
//	输出: true
//	示例 2:
//	输入: nums = [2,5,6,0,0,1,2], target = 3
//	输出: false
	public boolean search(int[] nums, int target) {
		if(nums==null||nums.length==0) {
			return false;
		}
		int left=0,right=nums.length-1,mid=0;
		while(left<=right) {
			mid=left+(right-left)/2;
			if(target==nums[mid]) {
				return true;
			}
			if(nums[mid]>nums[left]) {//左边有序
				if(nums[left]<=target&&target<nums[mid]) {
					right=mid-1;
				}else{
					left=mid+1;
				}
			}else if(nums[mid]<nums[left]) {//右边有序
				if(nums[mid]<target&&target<=nums[right]) {//{3,1,1}，3这种情况，3>1,在1的右边找，如果找不到不能返回false，答案可能在左边
					left=mid+1;
				}else{
					right=mid-1;
				}
			}else if(nums[mid]==nums[left]) {//无法判断是否有序，指针右挪，淘汰掉重复的
				left++;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		int[] nums={3,1,1};
		int target=3;
		System.out.println(new SearchInRotationArray2().search(nums, target));
	}
}
