package com.gzt.code1;
//删除链表的中间节点
public class RemoveMidNode {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            value = data;
        }
    }
    public static Node removeMidNode(Node head){
        //如果链表为null或者链表长度为1，则直接返回
        if(head == null || head.next == null){
            return head;
        }
        //如果链表长度为2,直接返回下一个节点
        if(head.next.next == null){
            return head.next;
        }
        //否则
        Node per = head;
        Node cur = head.next.next;
        while(cur.next!=null && cur.next.next != null){
            per = per.next;
            cur = cur.next.next;
        }
        per.next = per.next.next;
        return head;
    }
    public static void printNode(Node node){
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        node1.next.next.next.next.next = new Node(6);
        Node res = removeMidNode(node1);
        printNode(res);
    }
}
