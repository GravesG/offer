package com.gzt.code1;
//在双向链表删除倒数第K个节点
public class RemoveLastKthNode2 {
    public static class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode last;
        public DoubleNode(int data){
            value = data;
        }
    }

    public static DoubleNode removeLastKthNode(DoubleNode head,int lastKth){
        if(head == null || lastKth <1){
            return null;
        }
        DoubleNode cur = head;
        //先遍历一遍查看k的值，每移动一次K都减一
        while(cur != null){
            lastKth--;
            cur = cur.next;
        }
        if(lastKth ==0){
            //把头节点删了，直接返回第二个节点
            head = head.next;
            //把last指针指向null
            head.last = null;
        }
        if(lastKth < 0){
            cur = head;
            //找到要删除节点的前一个节点
            while(++lastKth != 0){
                cur = cur.next;
            }
            //让要删除节点的前一个节点next指针指向要删除节点的next，让删除节点的next的last指向要删除节点的前一个节点
            DoubleNode newNode = cur.next.next;
            cur.next = newNode;
            if(newNode != null){
                newNode.last = cur;
            }
        }
        return head;
    }

	//输出数组
    public static void printNode(DoubleNode node){
        while(node != null){
            System.out.print(node.value + " ");
            if(node.last == null){
                System.out.print(node.last);
            }else{
                System.out.print(node.last.value);
            }
            System.out.println();
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleNode node1 = new  DoubleNode(1);
        node1.last = null;
        node1.next = new  DoubleNode(2);
        node1.next.last = node1;
        node1.next.next = new  DoubleNode(3);
        node1.next.next.last = node1.next;
        node1.next.next.next = new  DoubleNode(4);
        node1.next.next.next.last = node1.next.next;
        node1.next.next.next.next = new  DoubleNode(5);
        node1.next.next.next.next.last = node1.next.next.next;
        DoubleNode res = removeLastKthNode(node1,3);
        printNode(res);
    }
}
