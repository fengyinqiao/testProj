package com.fengyq.leetcode;

public class IpToLong {
	private static long ipToLong(String ip) {
		String[] ips=ip.split("\\.");
		
		long result=0;
		result=(Long.parseLong(ips[0])<<24)+(Long.parseLong(ips[1])<<16)+(Long.parseLong(ips[2])<<8)+(Long.parseLong(ips[3]));
		return result;
	}
	private static String longToIp(long result) {
		// TODO Auto-generated method stub
		int mask=0xFF;
		String ip1=String.valueOf((result>>24)&mask);
		String ip2=String.valueOf((result>>16)&mask);
		String ip3=String.valueOf((result>>8)&mask);
		String ip4=String.valueOf(result&mask);
		return ip1+"."+ip2+"."+ip3+"."+ip4;
	}
	public static void main(String[] args) {
		String ip="255.255.255.255";
		System.out.println(ipToLong(ip));
		System.out.println(longToIp(ipToLong(ip)));
	}
}
