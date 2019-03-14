package com.gzt.jianzhiOffer;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Ex03 {

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (listNode == null) {
            return result;
        }
        ListNode cur = listNode;
        ListNode next = listNode.next;
        cur.next = null;
        ListNode temp = null;
        while (next != null) {
            temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        while (cur != null) {
            result.add(cur.val);
            cur = cur.next;
        }
        return result;
    }
}
