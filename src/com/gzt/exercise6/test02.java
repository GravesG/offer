package com.gzt.exercise6;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * 
 * @author Administrator
 *
 */
public class test02 {
	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode EntryNodeOfLoop(ListNode pHead) {
		if(pHead==null||pHead.next==null)return null;
		ListNode fast = pHead;
		ListNode slow = pHead;
		int count = 0;
		
		while(count < 2 ){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow && fast.next == slow.next){
				count++;
			}
		}
		fast = pHead;
		while(fast != slow ){
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next.next = new ListNode(7);
		node.next.next.next.next.next.next.next = new ListNode(8);
		node.next.next.next.next.next.next.next.next = new ListNode(9);
		node.next.next.next.next.next.next.next.next.next = new ListNode(10);
		node.next.next.next.next.next.next.next.next.next.next = node.next.next;
		
		System.out.println(EntryNodeOfLoop(node).val);
	}
}
