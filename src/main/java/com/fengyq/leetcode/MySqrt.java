package com.fengyq.leetcode;

//计算并返回 x 的平方根，其中 x 是非负整数。
//由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//示例 1:
//输入: 4
//输出: 2

//示例 2:
//输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//由于返回类型是整数，小数部分将被舍去。
public class MySqrt {
	public static int mySqrt(int x) {
		int i=-1;
		double ipow=0.0;
		while(true) {
			ipow=Math.pow(++i, 2);
			if(x==ipow) {
				return i;
			}
			if(x<ipow) {
				break;
			}
		}
		return i-1;
	}
	
	public static int mySqrt2(int x) {
		long left=0,right=x/2+1;
		long mid=0;
		while(left<=right){
//			mid=(left+right)/2;
			mid=left-(left-right)/2;
			long midPow=mid*mid;
			if(x<midPow) {
				right=mid-1;
			}else if(x>midPow) {
				left=mid+1;
			}else{
				return (int)mid;
			}
		}
		return (int)right;
	}
	
	public static void main(String[] args) {
		System.out.println(mySqrt2(2147395599));
	}
}
