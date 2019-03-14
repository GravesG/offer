package com.gzt.jianzhiOffer;

import javax.swing.tree.TreeNode;

public class Ex04 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        if(pre.length == 1){
            root.left = null;
            root.right = null;
            return root;
        }

        //找到节点在中序遍历的位置
        int i;
        for(i=0;i<in.length;i++){
            if(in[i] == pre[0]){
                break;
            }
        }

        //创建左子树
        if(i>0){
            int[] leftPre = new int[i];
            int[] leftIn = new int[i];

            for(int j=0;j<i;j++){
                leftPre[j] = pre[j+1];
            }
            for(int k=0;k<i;k++){
                leftIn[k] = in[k];
            }
            root.left = reConstructBinaryTree(leftPre,leftIn);
        }else{
            root.left = null;
        }

        //创建右子树

        if(pre.length-1-i > 0){
            int[] rightPre = new int[pre.length-1-i];
            int[] rightIn = new int[pre.length-1-i];
            for(int j = i+1;j<pre.length;j++){
                rightPre[j-i-1] = pre[j];
                rightIn[j-i-1] = in[j];
            }
            root.right = reConstructBinaryTree(rightPre,rightIn);
        }else{
            root.right = null;
        }
        return root;
    }
}
