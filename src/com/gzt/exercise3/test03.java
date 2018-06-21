package com.gzt.exercise3;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author Administrator
 *
 */
public class test03 {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	//非递归版本
	/*public static TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree == null){
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = pRootOfTree;
		TreeNode per = null;
		boolean isFirst = true;
		while(cur != null || !stack.isEmpty()){
			while(cur != null){
				//如果当前节点 的左孩子不为空，就遍历该节点真的左孩子
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			if(isFirst){
				//当第一次进来的时候，把头结点的位置改为最左边的子树
				per = cur;
				pRootOfTree = per;
				isFirst = false;
			}else{
				//改变原来二叉树的指针指向
				cur.left = per;
				per.right = cur;
				per = cur;
			}
			cur = cur.right;
		}
		return pRootOfTree;
    }*/
	
	//递归版
	public static TreeNode Convert(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while(p != null && p.right != null){
        	p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left != null){
        	p.right = root;
        	root.left = p;
        }
        
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right != null){
        	right.left = root;
        	root.right = right;
        }
		return left != null ? left : root;
    }
	
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(10);
		head.left = new TreeNode(6);
		head.right = new TreeNode(14);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(8);
		head.right.left = new TreeNode(12);
		head.right.right = new TreeNode(16);
		TreeNode convert = Convert(head);
		TreeNode temp = new TreeNode(0);
		while(convert != null){
			System.out.print(convert.val+" ");
			temp = convert;
			convert = convert.right;
		}
		System.out.println();
		while(temp != null){
			System.out.print(temp.val+" ");
			temp = temp.left;
		}
	}
}
