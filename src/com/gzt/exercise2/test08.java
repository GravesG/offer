package com.gzt.exercise2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。(按层遍历)
 * @author Administrator
 *
 */
public class test08 {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if(root == null){
			return null;
		}
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>(); 
		queue.push(root);
		while(!queue.isEmpty()){
			TreeNode cur = queue.pollFirst();
			list.add(cur.val);
			if(cur.left != null){
				queue.addLast(cur.left);
			}
			if(cur.right != null){
				queue.addLast(cur.right);
			}
		}
		return list;
    }
	
	public static ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
		if(root == null){
			return null;
		}
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>(); 
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode cur = queue.pop();
			System.out.print(cur.val+" ");
			if(cur.left != null){
				queue.add(cur.left);
			}
			if(cur.right != null){
				queue.add(cur.right);
			}
		}
		return list;
    }
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right= new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right= new TreeNode(5);
		node.right.left= new TreeNode(6);
		node.right.right= new TreeNode(7);
		PrintFromTopToBottom2(node);
	}
}
