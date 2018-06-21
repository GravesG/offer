package com.gzt.exercise4;

import java.util.Stack;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author Administrator
 *
 */
public class test05 {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	
	public static int TreeDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		int leftDepth = TreeDepth(root.left);
		int rightDepth = TreeDepth(root.right);
		int res = leftDepth>rightDepth?leftDepth:rightDepth;
		return res+1;
    }	
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right= new TreeNode(7);
		node.right.left.left = new TreeNode(8);
 		System.out.println(TreeDepth(node));
	}
}
