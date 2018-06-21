package com.gzt.exercise;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author Administrator
 *
 */
public class test7 {
	public double Power(double base, int exponent) {
		if(exponent == 0){
            return 1;
        }
        double result =1;
        int abx = Math.abs(exponent);
        for(int i=0;i<abx;i++){
            result *= base; 
        }
        if(exponent<0){
             result = 1/result;
         }
        return result;
        
	 }
}
