package com.gzt.code1;
//在单向链表删除倒数第K个节点
public class RemoveLastKthNode {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            value = data;
        }
    }

    public static Node removeLastKthNode(Node head,int lastKth){
        if(head == null || lastKth <1){
            return null;
        }
        Node cur = head;
        //先遍历一遍查看k的值，每移动一次K都减一
        while(cur != null){
            lastKth--;
            cur = cur.next;
        }
        if(lastKth ==0){
            //把头节点删了，直接返回第二个节点
            head = head.next;
        }
        if(lastKth < 0){
            cur = head;
            //找到要删除节点的前一个节点
            while(++lastKth != 0){
                cur = cur.next;
            }
            //让要删除节点的next指针指向要删除节点的next
            cur.next = cur.next.next;
        }
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
        Node node1 = new  Node(1);
        node1.next = new  Node(2);
        node1.next.next = new  Node(3);
        node1.next.next.next = new  Node(4);
        node1.next.next.next.next = new  Node(5);
        Node res = removeLastKthNode(node1,3);
        printNode(res);
    }
}
