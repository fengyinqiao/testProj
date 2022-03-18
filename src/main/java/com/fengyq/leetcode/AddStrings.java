package com.fengyq.leetcode;

public class AddStrings {
	/*
	 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
	 * 注意：
	 * num1 和num2 的长度都小于 5100. num1 和num2 都只包含数字 0-9. num1 和num2 都不包含任何前导零。
	 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
	 *  123
	 * 4567
	 * 4690
	 */
	public String addStrings(String num1, String num2) {
		int i=num1.length()-1,j=num2.length()-1;
		StringBuilder sb=new StringBuilder();
		int carry=0;
		while(i>=0||j>=0) {
			int char1=0;
			if(i>=0) {
				char1=num1.charAt(i--)-'0';
			}
			int char2=0;
			if(j>=0) {
				char2=num2.charAt(j--)-'0';
			}
			int k=char1+char2+carry;
			carry=k/10;
			sb.append(k%10);
		}
		if(carry!=0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		String num1="123";
		String num2="4567";
		System.out.println(new AddStrings().addStrings(num1, num2));
	}
}
