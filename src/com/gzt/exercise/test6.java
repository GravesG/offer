package com.gzt.exercise;

import javax.sound.midi.Synthesizer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author Administrator
 *
 */
public class test6 {
	public static  int RectCover(int target) {
		if(target <= 0){
			throw new IllegalArgumentException("不能小于0");
		}
		if(target == 1){
			return 1;
		}
		if(target == 2){
			return 2;
		}
		return RectCover(target-1)+RectCover(target-2);
    }
	public static void main(String[] args) {
		System.out.println(RectCover(3));
	}
}
