package com.gzt.nowcoder;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length <2){
            return ;
        }
        for(int end = arr.length-1 ; end > 0;end--){
            for(int i = 0;i < end;i++){
                if(arr[i] > arr[i+1]){
                    swap( i ,i+1 , arr);
                }
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
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
