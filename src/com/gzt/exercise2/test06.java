package com.gzt.exercise2;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 
 * @author Administrator
 *
 */
public class test06 {
	Stack<Integer> st1 = new Stack<Integer>();
	Stack<Integer> st2 = new Stack<Integer>();
	Integer res = null;

	public void push(int node) {
		if (st1.isEmpty()) {
			st1.push(node);
			res = node;
			st2.push(res);
		} else {
			if (node < res) {
				res = node;
				st2.push(res);
				st1.push(node);
			} else {
				st2.push(res);
				st1.push(node);
			}
		}
	}

	public void pop() {
		if (!st1.isEmpty() && !st2.isEmpty()) {
			st1.pop();
			st2.pop();
		}
	}

	public int top() {
		int top = st1.pop();
		st1.push(top);
		return top;
	}

	public int min() {
		int min = st2.pop();
		st2.push(min);
		return min;
	}

	public static void main(String[] args) {
		test06 t = new test06();
		t.push(3);
		System.out.println(t.min());
		t.push(4);
		System.out.println(t.min());
		t.push(2);
		System.out.println(t.min());
		t.push(3);
		System.out.println(t.min());
		t.pop();
		System.out.println(t.min());
		t.pop();
		System.out.println(t.min());
		t.pop();
		System.out.println(t.min());
		t.push(0);
		System.out.println(t.min());
	}
}
