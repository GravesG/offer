package com.gzt.exercise2;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某        二叉搜索树         的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author Administrator
 *
 */
public class test09 {
	
	public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        boolean res =getRes(sequence,0,sequence.length-1);
        return res;
    }

    public static boolean getRes(int[] s,int start,int end){
    	if(end-start <= 1){ //当只有两个数时，后序遍历只有一种情况（画图就可以理解意思）
    		return true;
    	}
    	int i = 0;
    	int j = 0;
    	//找出左右子树的分叉点
    	for(i = start; i< end ;i++){
    		if(s[s.length-1] < s[i]){
    			break;
    		}
    	}
    	j=i;
    	//如果头结点大于右子树的任意一个节点就返回false
    	for(;j<end;j++){
    		if(s[s.length-1] > s[j]){
    			return false;
    		}
    	}
    	boolean left = true;
    	if(i>0){
    		left = getRes(s,start,i-1);
    	}
    	boolean right = true;
    	if(i<s.length-1){
    		left = getRes(s,i,end-1);//end是最后一位，end-1是倒数第二位
    	}
		return left&&right;
        
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5};
		System.out.println(VerifySquenceOfBST(arr));
	}
}
