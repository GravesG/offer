package com.gzt.nowcoder;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        //把数组插入大根堆
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }

        int size = arr.length;
        //交换第一个和最后一个
        swap(0,size-1,arr);
        size = size-1;
        while (size > 0){
            heapify(arr,0,size);
            swap(0,size-1,arr);
            size = size-1;
        }
    }

    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index-1)/2]){
            swap(index,(index-1)/2,arr);
            index = (index-1)/2;
        }
    }

    public static void heapify(int[] arr,int index,int size){
        int left = index*2+1;
        while(left < size){
            //找到当前节点左右孩子的最大值
            int largest = 0;
            if(left +1 < size && arr[left] < arr[left+1] ){
                largest = left+1;
            }else{
                largest = left;
            }
            //判断当前值和最大孩子的大小
            if(arr[largest] > arr[index]){
                largest = largest;
            }else {
                largest = index;
            }
            //如果largest和当前index相等,就不换
            if(largest == index){
                break;
            }

            swap(largest,index,arr);
            index = largest;
            left = index*2+1;
        }
    }

    public static void swap(int a,int b,int[] arr){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,5,1,8,2,9,11,4};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
