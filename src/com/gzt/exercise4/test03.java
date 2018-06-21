package com.gzt.exercise4;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * @author Administrator
 *
 */
public class test03 {
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	//判断两个链表的长度，用长的链表先走多出的长度，再让两个链表一起走，再次遇到的第一个相同的节点就是要返回的结果
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null){
			return null;
		}
		int length1 = 0;
		int length2 = 0;
		
		ListNode cur1 = pHead1;
		ListNode cur2 = pHead2;
		
		while(cur1 != null){
			length1++;
			cur1 = cur1.next;
		}
		
		while(cur2 != null){
			length2++;
			cur2 = cur2.next;
		}
		int D_value = length1 > length2 ? length1-length2 :length2-length1;
		ListNode temp = null;
		
		if( length1 > length2 ){
			temp = pHead1;
			while(D_value !=0 ){
				temp = temp.next;
				D_value--;
			}
			cur2 = pHead2;
			while(cur2 != null ){
				if(cur2.val == temp.val){
					break;
				}
				cur2 = cur2.next;
				temp = temp.next;
			}
		}else{
			temp = pHead2;
			while(D_value !=0 ){
				temp = temp.next;
				D_value--;
			}
			cur1 = pHead1;
			while(cur1 != null ){
				if(cur1.val == temp.val){
					break;
				}
				cur1 = cur1.next;
				temp = temp.next;
			}
		}
		return temp;
    }
}
