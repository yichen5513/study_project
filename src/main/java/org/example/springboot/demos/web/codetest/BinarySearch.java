package org.example.springboot.demos.web.codetest;/*
 * @author      :  YC
 * @date        :  2026/9/28 19:23
 * @description :  some description
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 9, 13, 18, 24, 31, 39, 47};
        int target = 31;
//        int index = binarySearch1(arr,target);
        int index = binarySearch2(arr,target,0,arr.length-1);
        if(index != -1){
            System.out.println("找到目标数据了，它在数组的索引位置为："+index);
        }else {
            System.out.println("数组中没有该目标数据！");
        }
    }

    public static int binarySearch1(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if(arr[mid] > target){
                right = mid -1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] arr,int target,int left,int right){
        int index = -1;
        if (left <= right){
            int mid = (left+right)/2;
            if(arr[mid] > target){
                right = mid -1;
                index = binarySearch2(arr,target,left,right);
            } else if (arr[mid] < target) {
                left = mid + 1;
                index = binarySearch2(arr,target,left,right);
            }else {
                index =  mid;
            }
        }
        return index;
    }
}
