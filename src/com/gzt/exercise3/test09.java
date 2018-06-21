package com.gzt.exercise3;

import java.util.ArrayList;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author Administrator
 *
 */
public class test09 {
	public static String PrintMinNumber(int [] numbers) {
		if(numbers == null || numbers.length == 0){
			return "";
		}
		ArrayList<String> list = new ArrayList<>();
		process(numbers,0,list);
		return list.get(0);
    }
	
	public static ArrayList<String> process(int [] chs,int i,ArrayList<String> list){
		if(chs == null || chs.length == 0){
			return list;
		}
		if(i == chs.length-1){
			if(list.isEmpty()){
				list.add(returnType(chs));
			}else{
				String res = list.get(0);
				String temp = returnType(chs);
				for(int k=0; k<temp.length(); k++){
					if(temp.charAt(k) < res.charAt(k)){
						res = returnType(chs);
						list.clear();
						list.add(res);
						break;
					}
					if(temp.charAt(k) > res.charAt(k)){
						break;
					}
				}
			}
		}else{
			for(int j = i;j<chs.length;j++){
				swap(chs,i,j);
				
				process(chs,i+1,list);
				
				swap(chs,i,j);
			}
		}
		return list;
	}
	
	public static void swap(int [] chs,int a,int b){
		int temp = chs[a];
		chs[a] = chs[b];
		chs[b] = temp;
	}
	
	public static String returnType(int[] arr){
		String res = "";
		for(int i=0;i<arr.length;i++){
			res += String.valueOf(arr[i]);
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,1,2};
		System.out.println(PrintMinNumber(arr));
	}
}
