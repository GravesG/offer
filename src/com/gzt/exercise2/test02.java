package com.gzt.exercise2;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author Administrator
 *
 */
public class test02 {
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1 == null && list2 == null){
			return null;
		}
		if(list1 == null){
			return list2;
		}
		if(list2 == null){
			return list1;
		}
		ListNode first = list1;
		ListNode second = list2;
		ListNode result = null;
		ListNode head = null;
		while(first != null || second != null){
			if(first == null){
				if(result == null){
					result = second;
					break;
				}else{
					result.next = second;
					break;
				}
			}
			
			if(second == null){
				if(result == null){
					result = first;
					break;
				}else{
					result.next = first;
					break;
				}
			}
			
			if(first.val <= second.val){
				if(result == null){
					result = first;
					head = result;
					first = first.next;
				}else{
					result.next = first;
					result = result.next;
					first = first.next;
				}
			}else if(first.val > second.val){
				if(result == null){
					result = second;
					head = result;
					second = second.next;
				}else{
					result.next = second;
					result = result.next;
					second = second.next;
				}
			}
		}
		return head;
    }
	
	public static void main(String[] args) {
		test02 t = new test02();
		ListNode node1 = t.new ListNode(1);
		node1.next = t.new ListNode(3);
		node1.next.next = t.new ListNode(5);
		
		ListNode node2 = t.new ListNode(3);
		node2.next = t.new ListNode(4);
		node2.next.next = t.new ListNode(6);
		
		ListNode merge = t.Merge(node1,node2);
		while(merge != null){
			System.out.println(merge.val);
			merge = merge.next;
		}
	}
}
