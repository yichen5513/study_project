package org.example.springboot.demos.web.codetest;/*
 * @author      :  YC
 * @date        :  2026/9/28 21:45
 * @description :  some description
 */

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,10,8,3,9,2,6,4,7,1};
        int l = 0;
        int r = arr.length-1;

       quickSort(arr,l,r);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r) {
        if(l >= r) return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p-1);
        quickSort(arr, p+1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int base = arr[l];
        while(l < r){
            while(l < r && arr[r] >= base) r--;
            arr[l] = arr[r];
            while(l < r && arr[l] <= base) l++;
            arr[r] = arr[l];
        }
        arr[l] = base;
        return l;
    }
}
