package com.gzt.nowcoder;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2 ){
            return;
        }
        mergeProcess(arr,0,arr.length-1);
    }

    public static void mergeProcess(int[] arr, int L, int R) {
        if(L == R){
            return ;
        }
        int mid = (L+R)/2;
        mergeProcess(arr,L,mid);
        mergeProcess(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    public static void merge(int[] arr,int L,int mid,int R){
        int[] help = new int[R-L+1];
        int i=0;
        int p1 = L;
        int p2 = mid+1;
        while(p1 <= mid && p2 <= R){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= mid){
            help[i++] = arr[p1++];
        }

        while(p2 <= R){
            help[i++] = arr[p2++];
        }

        for(i=0;i<help.length;i++){
            arr[L+i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,5,1,8,2};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
