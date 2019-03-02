package com.gzt.nowcoder;

//链表相交问题 比较难
public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        //查找两个链表的入环节点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //两个无环链表相交
        if(loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }
        //两个有环链表相加
        if(loop1 != null && loop2 != null){
            return bothLoop(head1, loop1, head2, loop2);
        }
        //无环链表和有环链表不可能相交
        return null;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            //非常6+1类型
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1.next != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop2) {
                n--;
                cur2 = cur2.next;
            }
            if (cur1 != cur2) {
                return null;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            //天线宝宝类型
            cur1 = loop1.next;
            //循环一圈列表
            while (cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    //两个无环链表相交
    public static Node noLoop(Node head1, Node head2) {
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            n--;
            cur2 = cur2.next;
        }
        //判断两个链表是否相等
        if(cur1 != cur2){
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        //让长链表先走
        while (n != 0){
            n--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node getLoopNode(Node head) {
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node low = head.next;
        Node fast = head.next.next;
        //z只要快慢指针没有相交就一直走下去
        while(fast != low){
            //要判断快指针是否会指向空节点(即判断是否不存在环)
            if(fast == null || fast.next == null || fast.next.next == null){
                return null;
            }
            low = low.next;
            fast = fast.next.next;
        }

        //相遇后，让快指针回到开头
        fast = head;
        while(fast != low){
            fast = fast.next;
            low = low.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        //System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }
}
