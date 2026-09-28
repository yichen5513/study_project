package org.example.springboot.demos.web.codetest;/*
 * @author      :  YC
 * @date        :  2026/9/28 21:01
 * @description :  some description
 */

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,7,8,5,6,4,3,2,1};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
