package com.gzt.exercise;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author Administrator
 *
 */
public class test8 {
	public static void reOrderArray(int [] array) {
		int[] jArr = new int[array.length];
		int[] oArr = new int[array.length];
		int a=0;
		int b=0;
        for(int i=0;i<array.length;i++){
        	if(array[i]%2 == 0){
        		oArr[a++] = array[i];
        	}else{
        		jArr[b++] = array[i];
        	}
        }
        int[] result = new int[array.length];
        int i=0;
        int ia=0;
        int ib=0;
        while(ia < b){
        	result[i++] = jArr[ia++];
        }
        while(ib < a){
        	result[i++] = oArr[ib++];
        }
        array = result;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,8};
		reOrderArray(arr);
		System.out.println(Arrays.toString(arr));
	}
}
