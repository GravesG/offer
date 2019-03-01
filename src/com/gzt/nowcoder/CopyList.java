package com.gzt.nowcoder;

import java.util.HashMap;

public class CopyList {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    //采用hashmap
    public static Node copyList1(Node head){
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        Node help = head;
        while(help != null){
            map.get(help).next = map.get(help.next);
            map.get(help).rand = map.get(help.rand);
            help = help.next;
        }
        return map.get(head);
    }

    //复制节点的方法
    public static Node copyList2(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        //构造每个节点的复制节点
        while(cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        //拷贝rand
        cur = head;
        Node copy = null;
        while(cur != null){
            next = cur.next.next;
            copy = cur.next;
            copy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        //将两个链表分开
        cur = head;
        Node res = head.next;
        while(cur != null){
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
//      Node list = copyList1(head);
        Node list = copyList2(head);
        printRandLinkedList(list);
    }
}
