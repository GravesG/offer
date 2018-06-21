package com.gzt.exercise4;

import com.gzt.exercise4.test05.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author Administrator
 *
 */
public class test06 {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public static class ReturnType{
		boolean isB;
		int h;
		public ReturnType(boolean isB,int h){
			this.isB = isB;
			this.h = h;
		}
	}
	
	public static boolean IsBalanced_Solution(TreeNode root) {
		ReturnType res = process(root);
		return res.isB;
    }
	
	public static ReturnType process(TreeNode root){
		if(root == null){
			return new ReturnType(true,0);
		}
		ReturnType leftType = process(root.left);
		if(leftType.isB == false){
			return new ReturnType(false,0);
		}
		ReturnType rightType = process(root.right);
		if(rightType.isB == false){
			return new ReturnType(false,0);
		}
		if(Math.abs(leftType.h - rightType.h) > 1){
			return new ReturnType(false,0);
		}
		return new ReturnType(true , Math.max(leftType.h, rightType.h)+1);
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		node.left.left.left = new TreeNode(8);
		node.left.left.left.left = new TreeNode(9);
		System.out.println(IsBalanced_Solution(node));
	}
}
