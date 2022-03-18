package com.fengyq.leetcode;

public class MyPow {
	public static double myPow(double x, int n) {
		/*if(n==0) {//普通递归，n=2147483647时栈溢出
			return 1;
		}
		if(n>0) {
			return x*myPow(x,n-1);
		}
		if(n<0) {
			return (1/x)*myPow(x,n+1);
		}
		return -1;*/
		if(n==0) {//快速幂
			return 1;
		}
		if(n==1) {
			return x;
		}
		if(n==-1) {
			return 1/x;
		}
		double half=myPow(x,n/2);
		double rest=myPow(x,n%2);
		return half*half*rest;
		
	}
	
	public static void main(String[] args) {
		System.out.println(myPow(0.00001,2147483647));
		System.out.println(myPow(2,-3));
	}
}
