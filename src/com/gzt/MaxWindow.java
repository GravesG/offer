package com.gzt.code1;

import sun.applet.Main;

import java.util.Arrays;
import java.util.LinkedList;

public class MaxWindow {
    public static  int[] getMaxWindow(int[] arr, int w){
        if(arr == null || w<1 || arr.length <w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        //定义返回的数组
        int[] res = new int[arr.length-w+1];
        int index = 0;
        for(int i=0;i<arr.length;i++){
            //当qmax不为空，并且qmax的尾值小于arr当前位置的值，就把qmax尾部删除
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            //当qmax为空或者qmax的尾值大于arr当前位置的值
            qmax.addLast(i);
            //判断qmax的头部是否过期
            if(qmax.peekFirst() == i-w){
                qmax.pollFirst();
            }
            //从小标为2开始往res数组记录最大值
            if(i>=w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        int w = 3;
        int[] res = getMaxWindow(arr,w);
        System.out.println(Arrays.toString(res));
    }
}
