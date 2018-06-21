package com.gzt.exercise2;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author Administrator
 *
 */
public class test07 {

	public static boolean IsPopOrder(int [] pushA,int [] popA) {
		if(pushA == null || popA == null){
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(pushA[0]);
		int i=0;
		int j=1;
		while(i < popA.length){
			if(j == pushA.length && popA[i] != stack.peek()){
				return false;
			}
			if(stack.isEmpty()){
				stack.push(pushA[j]);
				j++;
			}
			if(popA[i] == stack.peek()){
				stack.pop();
				i++;
			}else{
				stack.push(pushA[j]);
				j++;
			}
		}
		return true;
    }
	
	public static void main(String[] args) {
		int [] a = new int[]{1,2,3,4,5};
		int [] b = new int[]{4,3,5,1,2};
		System.out.println(IsPopOrder(a,b));
	}
}
