package com.fengyq.leetcode;

import java.util.HashMap;

public class FourSumCount {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < C.length; j++) {
				int sum=D[i]+C[j];
				if(map.containsKey(sum)) {
					map.put(sum, map.get(sum)+1);
				}else {
					map.put(sum, 1);
				}
			}
		}
		
		int cnt=0;
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < A.length; j++) {
				int sum=-(B[i]+A[j]);
				if(map.containsKey(sum)) {
					cnt+=map.get(sum);
				}
			}
		}
		return cnt;
	}
}
