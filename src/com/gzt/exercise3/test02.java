package com.gzt.exercise3;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * @author Administrator
 *
 */
public class test02 {
	public static class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	public static RandomListNode Clone(RandomListNode pHead) {
		CloneNodes(pHead);  
        ConnectRandomNodes(pHead);  
        return ReConnectNodes(pHead); 
	}
	
	// 第一步：根据原始链表的每个结点N创建对应的结点N'
	public static void CloneNodes(RandomListNode pHead){
		RandomListNode node = pHead;
		while(node != null){
			RandomListNode cloneNode = new RandomListNode(node.label);
			cloneNode.next = node.next;
			cloneNode.random = null;
			node.next = cloneNode;
			node = cloneNode.next;
		}
	}
	
	// 第二步：设置复制出来结点的random.假设原始结点的随机指向S，复制出来结点的random指向S后一个  
    private static void ConnectRandomNodes(RandomListNode pHead){
    	RandomListNode node = pHead;
    	while(node != null){
    		RandomListNode cloneNode = node.next;
    		if(node.random != null){
    			cloneNode.random = node.random.next;
    		}
    		node = cloneNode.next;
    	}
    }
    
 // 第三步：把这个长链表拆分成两个链表，奇数位置连接起来就是原始链表，偶数结点连接起来就是复制结点  
    private static RandomListNode ReConnectNodes(RandomListNode pHead){
    	RandomListNode node = pHead;
    	RandomListNode cloneHead = null; 
    	RandomListNode cloneNode = null;
    	if(node!=null){
    		cloneHead = node.next;  
            cloneNode = node.next;
    	}
        while(node.next != null){
        	node.next = cloneNode.next;
        	node = node.next;
        	cloneNode.next = node.next;
        }
		return cloneHead;
    	
    }
	
    public static void main(String[] args)  
    {  
        RandomListNode head = new RandomListNode(1);  
        RandomListNode node2 = new RandomListNode(2);  
        RandomListNode node3 = new RandomListNode(3);  
        RandomListNode node4 = new RandomListNode(4);  
        RandomListNode node5 = new RandomListNode(5);  
        head.next = node2;  
        node2.next = node3;  
        node3.next = node4;  
        node4.next = node5;  
  
        head.random = node3;  
        node2.random = node5;  
        node4.random = node2;  
  
        RandomListNode copyList = Clone(head);  
        while (copyList != null)  
        {  
            System.out.print(copyList.label + " ");  
            copyList = copyList.next;  
        }  
  
    } 
}
