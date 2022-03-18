package com.fengyq.leetcode;

public class QuickSort {
//	int[] a= {23,46,0,8,11,18}
	private static void quickSort(int[] a,int left,int right) {
		if(left>right||left<0||right>a.length-1) {
			return;
		}
		int idx=getIdx(a,left,right);
//		while(left<right) {
//			if(a[right]<tmp) {
//				a[left]=a[right];
//				left++;
//				while(left<right) {
//					if(a[left]>tmp) {
//						a[right]=a[left];
//						right--;
//						break;
//					}
//					left++;
//				}
//				continue;
//			}
//			right--;
//		}
		quickSort(a, left, idx-1);
		quickSort(a,idx+1,right);
	}
	
	private static int getIdx(int[] a, int left, int right) {
		int tmp=a[left];
		while(left<right) {
			while(left<right&&a[right]>=tmp) {
				right--;
			}
			a[left]=a[right];
			while(left<right&&a[left]<=tmp) {
				left++;
			}
			a[right]=a[left];
		}
		a[left]=tmp;
		return left;
	}

	public static void main(String[] args) {
		int[] a= { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
		quickSort(a,0,a.length-1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
