package com.fengyq.leetcode;

public class LengthOfLongestSubstring {
		//输入: "abcabcbb"
		//输出: 3 
		//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		
		String ip="192.168.101.103";
		String[] ips=ip.split("\\.");
		int mask=0xFF;
		long result=0;
		result=(Long.parseLong(ips[0])<<24)+(Long.parseLong(ips[1])<<16)+(Long.parseLong(ips[2])<<8)+(Long.parseLong(ips[3]));
		System.out.println(result);
		
		String ip1=String.valueOf((result>>24)&mask);
		String ip2=String.valueOf((result>>16)&mask);
		String ip3=String.valueOf((result>>8)&mask);
		String ip4=String.valueOf(result&mask);
		System.out.println(ip1+"."+ip2+"."+ip3+"."+ip4);
	}
	public static int lengthOfLongestSubstring(String s) {
		int p1=0,p2=1,length=0;
		String subStr="";
		for (;p2 < s.length()&&p1<s.length();) {
			subStr=s.substring(p1, p2);
			if(subStr.indexOf(s.charAt(p2))!=-1){
				if(p2-p1>length){
					length=p2-p1;
				}
				p1++;
				p2=p1;
			}
			p2++;
		}
		if(p2==s.length()) {
			if(p2-p1>length) {
				length=p2-p1;
			}
		}
		return length;
	}
}
