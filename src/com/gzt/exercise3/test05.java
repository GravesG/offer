package com.gzt.exercise3;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author Administrator
 *
 */
public class test05 {
	public static int MoreThanHalfNum_Solution(int [] arr) {
		if(arr == null || arr.length == 0){
			return 0;
		}
		int result = arr[0];
		int count = 1; 
		for(int i=1;i<arr.length;i++){
			if(result == arr[i]){
				count++;
			}else{
				count--;
				if(count == 0){
					result = arr[i];
					count=1;
				}
			}
		}
		if(!checkMoreThanHalf(arr,result)){
			return 0;
		}
        return result;  
    }
	public static boolean checkMoreThanHalf(int[] arr,int result){
		int count = 0;
		for(int i=0;i<arr.length;i++){
			if(result == arr[i]){
				count++;
			}
		}
		if(count > arr.length/2){
			return true;
		}
		return false;  
    }  
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,3,3,3,1,2,0};
		System.out.println(MoreThanHalfNum_Solution(arr));
	}
}
