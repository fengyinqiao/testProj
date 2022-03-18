package com.fengyq.leetcode;

import java.util.BitSet;

public class FindDuplicate {
	public int findDuplicate(int[] nums) {
		BitSet bitSet=new BitSet();
		for (int i = 0; i < nums.length; i++) {
			if(bitSet.get(nums[i])) {
				return nums[i];
			}
			bitSet.set(nums[i]);
		}
		return -1;
    }
}
