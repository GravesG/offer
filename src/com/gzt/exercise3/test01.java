package com.gzt.exercise3;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author Administrator
 *
 */
public class test01 {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	
	ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
	ArrayList<Integer> list = new ArrayList<>();
	int num = 0;
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		if(root == null){
			return lists;
		}
		num += root.val;
		list.add(root.val);
		//当当前数的和为目标数并且该节点是叶子节点时（左右孩子为null），就把list添加到总lists中去
		if(num == target && root.left == null && root.right == null){
			ArrayList<Integer> temp = new ArrayList<>();
			for(Integer i : list){
				temp.add(i);
			}
			lists.add(temp);
		}
		//遍历左孩子
		if(num < target && root.left != null){
			FindPath(root.left,target);
		}
		//遍历右孩子
		if(num < target && root.right != null){
			FindPath(root.right,target);
		}
		//遍历完成后删除最后添加的节点，目的是为了保住前面的list
		num -= root.val;
		list.remove(list.size()-1);
		return lists;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);  
        root.left = new TreeNode(2);  
        root.right = new TreeNode(3);  
        root.left.left = new TreeNode(4);  
        root.left.right = new TreeNode(4);  
        root.right.left = new TreeNode(6);  
        root.right.right = new TreeNode(7);  
        int target = 7;  
        test01 s = new test01();  
        ArrayList<ArrayList<Integer>> lists = s.FindPath(root, target);  
  
        for (int i = 0; i < lists.size(); i++)  
        {  
            System.out.println(lists.get(i));  
        }  
	}
}
