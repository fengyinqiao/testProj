package com.fengyq.leetcode;

import java.math.BigDecimal;

public class MySqrtForDecimal {
//	已知sqrt(2)约等于1.414，要求不用数学库，求sqrt(2)精确到小数点后10位
	static BigDecimal _2=new BigDecimal(Double.toString(2));
	public static void main(String[] args) {
		BigDecimal left=new BigDecimal(Double.toString(1.4));
		BigDecimal right=new BigDecimal(Double.toString(1.5));
		int scale=10;
		double result=binarySearch(left,right,scale);
		System.out.println(result);
	}

	private static double binarySearch(BigDecimal left, BigDecimal right,int scale) {
		if(right.scale()==scale) {
			return right.doubleValue();
		}
		if(left.scale()==scale) {
			return left.doubleValue();
		}
//		double mid=left-(left-right)/2;
//		double mid=(left+right)/2;
		BigDecimal mid=left.add(right).divide(_2);
//		if(2<mid*mid) {
		if(_2.compareTo(mid.multiply(mid))<0) {
			return binarySearch(left, mid, scale);
		}else {
			return binarySearch(mid, right, scale);
		}
	}
	
}
