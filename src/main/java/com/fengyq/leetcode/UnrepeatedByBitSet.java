package com.fengyq.leetcode;

import java.util.BitSet;
//在2.5亿个整数中找出不重复的整数，注，内存不足以容纳这2.5亿个整数。
public class UnrepeatedByBitSet {
	public static void main(String[] args) {
		int[] a={1,1,2,2,2,3,4,5,6,7};
		BitSet bs1=new BitSet();
		BitSet bs2=new BitSet();
		for (int i = 0; i < a.length; i++) {
			if(!bs1.get(a[i])) {
				bs1.set(a[i]);
			}else {
				bs2.set(a[i]);
			}
			
		}
		for (int i = 0; i < a.length; i++) {
			if(bs1.get(a[i])&&!bs2.get(a[i])){
				System.out.print(a[i]+" ");
			}
		}
	}
}
