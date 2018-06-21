package com.gzt.exercise5;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * @author Administrator
 *
 */
public class test05 {
	public static int StrToInt(String str) {
		if(str.length() == 0 || str.equals("")){
			return 0;
		}
		char[] charArray = str.toCharArray();
		int start = 0;
		boolean flag = true;    //区分正负号
		
		//探查有无标志位
		if(charArray[0] == '-' || charArray[0] == '+'){
			//如果含符号位，则从下标为1的数开始计算
			start = 1;
			if(charArray[0] == '-'){
				flag = false;
			}
		}
		
		int sum = 0;
		for(int i=start;i<charArray.length;i++){
			//如果包含数字之外的数返回0
			if(charArray[i]<48 || charArray[i]>57){
				return 0;
			}
			sum = sum*10+(charArray[i]-48);
		}
		
		return flag?sum:sum*(-1);
    }
	
	public static void main(String[] args) {
		System.out.println(StrToInt("-12q3"));
	}
}
