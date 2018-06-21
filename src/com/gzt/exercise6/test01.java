package com.gzt.exercise6;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * @author Administrator
 *
 */
public class test01 {
	static int[] arr = new int[256];
	static StringBuffer sb = new StringBuffer();
	//Insert one char from stringstream
    public static void Insert(char ch)
    {
        if(ch > 256){
        	return ;
        }
        arr[ch]++;
        sb.append(ch);
    }
  //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
    	char[] temp = sb.toString().toCharArray();
    	for(char c:temp){
    		if(arr[c] == 1){
    			return c;
    		}
    	}
		return '#';
    }
    
    public static void main(String[] args) {
    	/*Insert('g');
    	Insert('o');
    	Insert('o');
    	Insert('g');
    	Insert('l');
    	Insert('e');*/
    	System.out.println(FirstAppearingOnce());
	}
}
