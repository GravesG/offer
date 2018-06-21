package com.gzt.exercise2;

import com.gzt.exercise2.test03.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
输入描述:
二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * @author Administrator
 *
 */
public class test04 {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	public void Mirror(TreeNode root) {
        if(root ==null){
        	return ;
        }
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }
	
	public void swap(TreeNode root){
		TreeNode temp = null;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
	
	public static void preOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.val + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	
	public static void main(String[] args) {
		test04 t = new test04();
		TreeNode node1 = t.new TreeNode(1);
		node1.left = t.new TreeNode(2);
		node1.left.left = t.new TreeNode(4);
		node1.left.right = t.new TreeNode(5);
		node1.right = t.new TreeNode(3);
		node1.right.left = t.new TreeNode(6);
		node1.right.right = t.new TreeNode(7);
		
		preOrderRecur(node1);
		System.out.println();
		t.Mirror(node1);
		preOrderRecur(node1);
	}
}
