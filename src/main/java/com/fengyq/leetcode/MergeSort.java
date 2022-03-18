package com.fengyq.leetcode;

import java.io.IOException;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a={6,5,4,3,2,1};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a, int left, int right) {
        if(left>=right) {
            return;
        }
        int mid=left+(right-left)/2;
        mergeSort(a,left,mid);
        mergeSort(a,mid+1,right);
        merge(a,left,mid,right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int i=left,j=mid+1;
        int[] atmp=new int[right-left+1];
        int k=0;
        while (i<=mid&&j<=right) {
            if(a[i]<a[j]) {
                atmp[k++]=a[i++];
            }else {
                atmp[k++]=a[j++];
            }
        }
        while(i<=mid) {
            atmp[k++]=a[i++];
        }
        while(j<=right) {
            atmp[k++]=a[j++];
        }
        for (int l = 0; l < atmp.length; l++) {
            a[left++]=atmp[l];
        }
    }
}
