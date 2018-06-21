package com.gzt.exercise4;

import java.util.HashMap;
import java.util.Set;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author Administrator
 *
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class test07 {
	public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
       if(array == null || array.length ==0){
    	   return;
       }
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i=0;i<array.length;i++){
    	   if(map.containsKey(array[i])){
    		   map.put(array[i], map.get(array[i])+1);
    	   }else{
    		   map.put(array[i], 1);
    	   }
       }
       
       Set<Integer> keySet = map.keySet();
       int[] temp = new int[2];
       
       for(int i:keySet){
    	   if(map.get(i)==1){
    		   if(temp.length==0){
    			   System.out.println(i);
    			   temp[0] = i;
    		   }else{
    			   System.out.println(i);
    			   temp[1] = i;
    		   }
    	   }
       }
       
       num1[0]=temp[0];
       num2[0]=temp[1];
    }
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2,2,3,3,4,5,5};
		int[] num1 = new int[1];
		int[] num2 = new int[1];	
		FindNumsAppearOnce(array,num1,num2);
	}
}
