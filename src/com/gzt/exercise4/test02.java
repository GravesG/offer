package com.gzt.exercise4;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * @author Administrator
 *
 */
public class test02 {
	public static int FirstNotRepeatingChar(String str) {
		if(str == null || str.equals("")){
			return -1;
		}
		int index=0;
		int[] chs = new int[52];
		char[] strs = str.toCharArray();
		for(int i=0;i<strs.length;i++){
			 if(strs[i]>=65 && strs[i]<=90){
				 chs[strs[i]-65]++;
			 }
			 if(strs[i]>=97 && strs[i]<=122){
				 chs[strs[i]-71]++;
			 }
		}
		
		for(int i=0;i<strs.length;i++){
			if(strs[i]>=65 && strs[i]<=90){
				if(chs[strs[i]-65]==1){
					index=i;
					break;
				}
			}
			if(strs[i]>=97 && strs[i]<=122){
				if(chs[strs[i]-71]==1){
					index=i;
					break;
				}
			}
		}
        return index;
    }
	
	public static void main(String[] args) {
		String str = "";
		System.out.println(FirstNotRepeatingChar(str));
	}
}
