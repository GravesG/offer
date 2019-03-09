package com.gzt.nowcoder;

import java.util.Arrays;

public class QuickSortBetter {
    public static void quickSort(int[] arr,int L,int R){
        if(L < R){
            //随机替换最后一个数----------------->与经典快排的区别
            swap(L+(int)Math.random()*(R-L+1),R,arr);
            int[] p = partition(arr,L,R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[0] +1,R);
        }
    }

    public static int[] partition(int[] arr, int L,int R){
        int less = L-1;
        int more = R;
        while(L < more){
            if(arr[L] < arr[R]){
                swap(L++,++less,arr);
            }else if(arr[L] > arr[R]){
                swap(L,--more,arr);
            }else{
                L++;
            }
        }
        swap(more,R,arr);
        return new int[]{less+1,more};
    }

    public static void swap(int a,int b,int[] arr){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,5,1,8,2,9,7,12,2};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
