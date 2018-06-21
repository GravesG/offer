package com.gzt.exercise;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * @author Administrator
 *
 */
public class test3 {
	/*public static int Fibonacci(int n) {
		if(n <0 ){
			throw new IllegalArgumentException("应该大于0");
		}
		if(n==0){
			return 0;
		}
        if(n == 1 || n ==2){
            return 1;
        }else{
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }*/
	
	public static int Fibonacci(int n) {
		int a=1,b=1,c=0;
        if(n<0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else{
            for (int i=3;i<=n;i++){
                c=a+b;
                a=b;
                b=c;
            }
            return c;
        }
    }
	
	public static void main(String[] args) {
		long a=System.currentTimeMillis();
		int n =6;
		System.out.println(Fibonacci(n));
		long b=System.currentTimeMillis();
		System.out.println(b-a);
	}
}
