package com.gzt;

public class Solution {
	//递归
	public int JumpFloor(int target) {
        if(target == 0){
        	return 0;
        }
        if(target == 1){
        	return 1;
        }
        return 2*JumpFloor(target-1);
    }
	
	//非递归
	public int JumpFloor2(int target) {
        if(target == 0){
        	return 0;
        }
        if(target == 1){
        	return 1;
        }
        int a=1; // 相当于f(1)
        int result = 0;
        for(int i=2;i<=target;i++){
        	result = 2*a;
        	a = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution st = new Solution();
        System.out.println(st.JumpFloor(4));
    }
}
