package com.gzt.exercise;

import java.util.Stack;

import javax.sound.midi.Synthesizer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author Administrator
 *
 */
public class test9 {
	
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode FindKthToTail(ListNode head,int k) {
		
		if(head == null){
			return null;
		}
		//Stack<ListNode> stack = new Stack<>();
		int num = 0;
		ListNode cur = head;
		while(cur != null){
			//stack.push(head);
			cur = cur.next;
			num++;
		}
		if(k > num){
			return null;
		}
		if(k == num){
			return head;
		}
		ListNode result = null;
		int n = num-k;
		while(n > 0){
			result = head.next;
			head = head.next;
			n--;
		}
		return result;
    }
	
	public static void main(String[] args) {
		test9 t = new test9();
		ListNode l = t.new ListNode(1);
		l.next = t.new ListNode(2);
		l.next.next = t.new ListNode(3);
		l.next.next.next = t.new ListNode(4);
		l.next.next.next.next = t.new ListNode(5);
		ListNode findKthToTail = t.FindKthToTail(l,5);
		System.out.println(findKthToTail.val);
	}
}
