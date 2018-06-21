package com.gzt.exercise;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author Administrator
 *
 */
public class test5 {
	// 递归
	public int JumpFloor(int target) {
		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		return 2 * JumpFloor(target - 1);
	}

	// 非递归
	public int JumpFloor2(int target) {
		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		int a = 1; // 相当于f(1)
		int result = 0;
		for (int i = 2; i <= target; i++) {
			result = 2 * a;
			a = result;
		}
		return result;
	}

	public static void main(String[] args) {
		test5 st = new test5();
		System.out.println(st.JumpFloor(4));
	}
}
