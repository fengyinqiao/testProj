package com.fengyq.leetcode;

public class ReverseInt {
	/*
	 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 示例 1: 输入: 123 输出: 321  示例 2: 输入: -123
	 * 输出: -321 示例 3: 输入: 120 输出: 21
	 */
	public int reverse(int x) {
		int res=0;
		int y=x;
		int mod=0;
		while(y!=0) {
			mod=y%10;
			y=y/10;
			if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&mod>Integer.MAX_VALUE%10)) {
				return 0;
			}
			if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&mod<Integer.MIN_VALUE%10)) {
				return 0;
			}
			res=res*10+mod;
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new ReverseInt().reverse(-2147483648));
	}
}
