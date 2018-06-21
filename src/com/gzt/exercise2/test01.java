package com.gzt.exercise2;

import com.gzt.exercise.test9;
import com.gzt.exercise.test9.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author Administrator
 *
 */
public class test01 {
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	 public ListNode ReverseList(ListNode head) {
		 if(head ==null){
			 return null;
		 }
		 ListNode first = head;
		 ListNode second = head.next;
		 ListNode third = null;
		 first.next = null;
		 while(first != null && second!=null){
			 third = second.next;
			 second.next = first;
			 first = second;
			 second = third;
		 }
		return first;
	 }
	 
	 public static void main(String[] args) {
		 	test01 t = new test01();
			ListNode l = t.new ListNode(1);
			l.next = t.new ListNode(2);
			l.next.next = t.new ListNode(3);
			l.next.next.next = t.new ListNode(4);
			l.next.next.next.next = t.new ListNode(5);
			ListNode findKthToTail = t.ReverseList(l);
			while(findKthToTail!=null){
				System.out.println(findKthToTail.val);
				findKthToTail = findKthToTail.next;
			}
	}
}
