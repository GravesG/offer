package com.gzt.exercise2;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * @author Administrator
 *
 */
public class test05 {
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
		if(matrix == null){
			return null;
		}
		ArrayList<Integer> list = new ArrayList<>();
		int lefta = 0;
		int leftb = 0;
		int righta = matrix.length-1;
		int rightb = matrix[0].length-1;
		while(lefta <= righta && leftb<=rightb ){
			//printside(matrix,lefta++,leftb++,righta--,rightb--);
			if(lefta == righta){//同一行
				for(int i = leftb; i<=rightb; i++){
					list.add(matrix[lefta][i]);
					System.out.println(matrix[lefta][i]);
				}
			}else if(leftb == rightb){
				for(int i = lefta; i<=righta; i++){
					list.add(matrix[i][rightb]);
					System.out.println(matrix[i][rightb]);
				}
			}else{
				int curC = lefta;
				int curR = leftb;
				while(curC != rightb){
					list.add(matrix[lefta][curC]);
					System.out.print(matrix[lefta][curC]+",");
					curC++;
				}
				while(curR != righta){
					list.add(matrix[curR][rightb]);
					System.out.print(matrix[curR][rightb]+",");
					curR++;
				}
				while(curC != lefta){
					list.add(matrix[righta][curC]);
					System.out.print(matrix[righta][curC]+",");
					curC--;
				}
				while(curR != leftb){
					list.add(matrix[curR][leftb]);
					System.out.print(matrix[curR][leftb]+",");
					curR--;
				}
			}
			
			lefta++;
			leftb++;
			righta--;
			rightb--;
		}
		return list;
    }
	
	public static void printside(int [][] matrix,int lefta,int leftb,int righta,int rightb){
		if(lefta == righta){//同一行
			for(int i = leftb; i<=rightb; i++){
				System.out.println(matrix[lefta][i]);
			}
		}else if(leftb == rightb){
			for(int i = lefta; i<=righta; i++){
				System.out.println(matrix[i][rightb]);
			}
		}else{
			int curC = lefta;
			int curR = leftb;
			while(curC != rightb){
				System.out.print(matrix[lefta][curC]+",");
				curC++;
			}
			while(curR != righta){
				System.out.print(matrix[curR][rightb]+",");
				curR++;
			}
			while(curC != lefta){
				System.out.print(matrix[righta][curC]+",");
				curC--;
			}
			while(curR != leftb){
				System.out.print(matrix[curR][leftb]+",");
				curR--;
			}
		}
	}
	
	public static void main(String[] args) {
//		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
//				{ 13, 14, 15, 16 } };
		int[][] matrix = { { 1} };
		printMatrix(matrix);

	}
}
