package com.gzt.code1;
//删除链表a/b处的节点
public class RemoveByRatio {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            value = data;
        }
    }

    public static Node removeByRatio(Node head,int a,int b){
        //如果分子为0或者分子比分母大
        if(a < 1 || a > b){
            return head;
        }
        //否则
        int n=0;
        Node cur = head;
        //获取链表长度
        while(cur != null){
            n++;
            cur = cur.next;
        }
        //知道要删除哪个节点    (ceil)向上取整
        n = (int)Math.ceil(((double)(a*n)/ (double)b));
        cur = head;
        while(--n != 1){
            cur = cur.next;
        }
        cur.next = cur.next.next;
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
        node1.next.next.next.next.next.next = new Node(7);
        Node res = removeByRatio(node1,5,6);
        printNode(res);
    }
}
