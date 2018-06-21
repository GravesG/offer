package com.gzt.exercise3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @author Administrator
 *
 */
public class test04 {
		
	public static ArrayList<String> Permutation(String str) {
		if(str == null){
			return null;
		}
		ArrayList<String> list = new ArrayList<>();
		process(str.toCharArray(),0,list);
		Collections.sort(list);
		return list;
    }
	
	public static ArrayList<String> process(char[] chs,int i,ArrayList<String> list){
		if(chs == null || chs.length == 0){
			return list;
		}
		if(i == chs.length-1){
			if(!list.contains(String.valueOf(chs))){
				list.add(String.valueOf(chs));
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
	
	public static void swap(char[] chs,int a,int b){
		char temp = chs[a];
		chs[a] = chs[b];
		chs[b] = temp;
	}
	
	public static void main(String[] args) {
		String str = "abc";
		Permutation(str);
	}
}
