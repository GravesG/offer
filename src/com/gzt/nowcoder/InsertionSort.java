package com.gzt.nowcoder;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        if(arr == null || arr.length < 2 ){
            return;
        }

        for(int i=1; i<arr.length; i++){
            for(int j=i-1; j>=0 && arr[j] > arr[j+1]; j--){
                swap(j,j+1,arr);
            }
        }
    }

    public static void swap(int a,int b,int[] arr){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,5,1,8,2};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
