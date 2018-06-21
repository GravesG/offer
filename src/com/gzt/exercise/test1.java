package com.gzt.exercise;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author Administrator
 *
 */
public class test1 {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	stack1.push(node);
    }
    
    public int pop() {
    	
    	if(!stack1.isEmpty()){
    		int result = 0;
    		while(stack1.size() >1){
    			stack2.push(stack1.pop());
    		}
    		result = stack1.pop();
    		while(!stack2.isEmpty()){
    			stack1.push(stack2.pop());
    		}
    		return result;
    	}else{
    		throw new RuntimeException("Queue is empty!");
    	}
		
    }
}
