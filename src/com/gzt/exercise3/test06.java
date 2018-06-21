package com.gzt.exercise3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 * @author Administrator
 *
 */
public class test06 {
	public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		if(input == null || input.length == 0){
			return null;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		for(int i=0;i<input.length;i++){
			if(maxHeap.size() != k){
				maxHeap.offer(input[i]);
			}else{
				if(input[i]<maxHeap.peek()){
					maxHeap.poll();
					maxHeap.offer(input[i]);
				}
			}
		}
		while(!maxHeap.isEmpty()){
			list.add(maxHeap.poll());
		}
		return list;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,4,7,1,2,5,6,8};
		ArrayList<Integer> list = GetLeastNumbers_Solution(arr,4);
		System.out.println(list.toString());
	}
}
