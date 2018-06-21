package com.gzt.exercise;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author Administrator
 *
 */
public class test4 {
	// 没错但是过不了在线监测
	
	/*public int JumpFloor(int target) {
		if (target < 0) {
			return 0;
		}
		int[] fib = { 0, 1, 2 };
		if (target < 3) {
			return fib[target];
		}
		return JumpFloor(target - 1) + JumpFloor(target - 2);
	}*/
	 

	// 可以过在线监测 但是要用 436ms  9176k
	public int JumpFloor(int target) {
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		return JumpFloor(target - 1) + JumpFloor(target - 2);
	}
	 

	//能过在线测试并且只用了16ms 8704k
	/*public int JumpFloor(int target) {
		if (target < 0)
			return 0;
		int[] fib = { 0, 1, 2 };
		if (target < 3)
			return fib[target];
		int total = 0;
		int firstElem = 1;
		int secondElem = 2;
		for (int i = 3; i <= target; i++) {
			total = firstElem + secondElem;
			firstElem = secondElem;
			secondElem = total; // 迭代
		}
		return total;
	}*/
}
