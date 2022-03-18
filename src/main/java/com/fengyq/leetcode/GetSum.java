package com.fengyq.leetcode;

public class GetSum {
//	不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
//	示例 1:
//	输入: a = 1, b = 2
//	输出: 3
	public static int getSum(int a, int b) {
		if(b==0) {
			return a;
		}
		if(a==0) {
			return b;
		}
		int noCarryResult=a^b;
		int carryResult=(a&b)<<1;
		return getSum(noCarryResult,carryResult);
	}
	public static void main(String[] args) {
		System.out.println(getSum(1,2));
		System.out.println(getSum(-2,3));
	}
}
