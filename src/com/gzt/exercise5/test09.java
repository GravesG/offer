package com.gzt.exercise5;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author Administrator
 *
 */
public class test09 {
	public static boolean isNumeric(char[] str) {
		// 如果这个数使用科学计数法表示，将数字分成两部分判断
        int posE = -1;//posE代表e或E的位置
        //如果含E或e
        if (contains(str, 'E') || contains(str, 'e')) {
        	for(int i=0;i<str.length;i++){
        		if(str[i] == 'e' || str[i] == 'E'){
        			posE = i;
        			break;
        		}
        	}
        	
        	//判断e是否在开头或者结尾
        	if(posE == 0 || posE == str.length-1){
        		return false;
        	}
        	
        	//将数组分为左右两块处理
        	char[] left = new char[posE];
        	char[] right = new char[str.length-1-posE];
        	 left = subChars(str, 0, posE);
             right = subChars(str, posE + 1, str.length);
            
             //右边眼判断有没有符号位
             if (starWith(right, '-') || starWith(right, '+')) {
                 right = subChars(right, 1, right.length);
             }
             return isDecimal(left) && isDigit(right);
        }else{
        	//否则是否是纯数字
        	return isDecimal(str);
        }
    }
	
	public static boolean isDecimal(char[] str) {
        if (starWith(str, '-') || starWith(str, '+')) {
            str = subChars(str, 1, str.length);
        }
        if (contains(str, '.')) {// 如果是小数
            int posE = -1;
            for (int i = 0; i < str.length; i++) {
                if (str[i] == '.') {
                    posE = i;
                    break;
                }
            }
            if (posE == 0 || posE == str.length - 1) {
                return true;
            }
            char[] left = new char[posE];
            char[] right = new char[str.length - posE - 1];
            left = subChars(str, 0, posE);
            right = subChars(str, posE + 1, str.length);
            return isDigit(left) && isDigit(right);

        } else {// 如果不是小数
            return isDigit(str);
        }
    }
	
	//判断纯数字
	public static boolean isDigit(char[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] < '0' || num[i] > '9') {
                return false;
            }
        }
        return true;
    }
	
	public static boolean starWith(char[] str,char c){
		if(str[0] == c){
			return true;
		}else{
			return false;
		}
	}
	
	public static char[] subChars(char[] str,int start,int end){
		char[] temp = new char[end-start];
		for(int i=start;i<end;i++){
			temp[i-start] = str[i];
		}
		return temp;
		
	}
	
	public static boolean contains(char[] str,char c){
		for(int i=0;i<str.length;i++){
			if(str[i] == c){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		char[] ch = new char[]{'3','.','1','.','2'};
		System.out.println(isNumeric(ch));
	}
	
	
}
