package com.gzt.exercise5;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @author Administrator
 *
 *解题思路：先翻转前一部分，在翻转后一部分，再翻转整体
 */
public class test01 {
	public static String LeftRotateString(String str,int n) {
		if(str == null || str.equals("")){
			return "";
		}
		char[] chs = str.toCharArray();
		if(n==chs.length){
			return str;
		}
		
		if(n>0 && n<chs.length){
			char[] front =new char[n];
			int num = 0;
			for(int i=0;i<n;i++){
				front[i] = chs[i];
				num++;
			}
			char[] behind = new char[chs.length-n];
			for(int j=0;j<behind.length;j++){
				behind[j] = chs[num++];
			}
			turn(front);
			turn(behind);
			System.arraycopy(front, 0, chs, 0, front.length);  
			System.arraycopy(behind, 0, chs, front.length, behind.length); 
			turn(chs);
			return String.valueOf(chs);
		}else{
			return str;
		}
    }
	
	public static void turn(char[] arr){
		int i=0;
		int j=arr.length-1;
		while(i < j){
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		String str = "XYZdefabc";
		System.out.println(LeftRotateString(str,3));
	}
}
