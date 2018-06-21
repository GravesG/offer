package com.gzt.exercise2;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author Administrator
 *
 */
public class test03 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		boolean result = false;
		if(root1 != null && root2 != null){
			if(root1.val == root2.val){
				result = isSame(root1,root2);
			}
			if(result == false){
				result = HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
			}
		}
		return result;
    }
	
	public boolean isSame(TreeNode root1,TreeNode root2){
		if(root2==null)  
            return true;  
        if(root1==null)  
            return false;  
        if(root1.val==root2.val){  
            return isSame(root1.left,root2.left)&& isSame(root1.right,root2.right);  
        }  
        return false;  
	}
	
	public static void main(String[] args) {
		test03 t = new test03();
		TreeNode node1 = t.new TreeNode(1);
		node1.left = t.new TreeNode(2);
		node1.left.left = t.new TreeNode(4);
		node1.left.right = t.new TreeNode(5);
		node1.right = t.new TreeNode(3);
		
		TreeNode node2 = t.new TreeNode(2);
		node2.left = t.new TreeNode(4);
		node2.right = t.new TreeNode(5);
		
		System.out.println(t.HasSubtree(node1, node2));
	}
}
