package com.gzt.exercise4;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数， 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * @author Administrator 对应每个测试案例，输出两个数，小的先输出
 */
public class test09 {
	public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		
		ArrayList<Integer> resList = new ArrayList<>();
		if(array == null || array.length ==0){
			return resList;
		}
		int i=0;
		int j=array.length - 1;
		int left = array[i];
		int right = array[j];
		int cur = left + right;
		int multi = 0;
		int[] temp = new int[2];
		while (left < right) {
			if (cur == sum) {
				int res = left * right;
				if (multi == 0) {
					multi = res;
					temp[0] = left;
					temp[1] = right;
				} else {
					if (res <= multi) {
						temp[0] = left;
						temp[1] = right;
					}
				}
				cur -= left;
				left = array[i++];
				cur += left;
			} else if (cur < sum) {
				cur -= left;
				left = array[i++];
				cur += left;
			} else {
				cur -= right;
				right = array[j--];
				cur += right;
			}
		}
		if(temp[0]==0 && temp[1] == 0){
			return resList;
		}
		resList.add(temp[0]);
		resList.add(temp[1]);
		return resList;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 4, 7, 11, 15 };
		System.out.println(FindNumbersWithSum(array, 15).toString());
	}
}
