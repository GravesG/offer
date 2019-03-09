package com.gzt.nowcoder;

public class SelectionSort {

    public static void selectionSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for(int i=0; i<arr.length-1; i++){
            int minIndex = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(i,minIndex,arr);
        }
    }

    public static void swap(int a,int b,int[] arr){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
