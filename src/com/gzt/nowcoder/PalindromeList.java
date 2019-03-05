package com.gzt.nowcoder;

public class PalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isPalindrome(Node node) {
        if (node == null || node.next == null) {
            return true;
        }
        Node fast = node;
        Node slow = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //此时慢指针到了中间位置,让快指针指向慢指针的下一个
        fast = slow.next;
        slow.next = null;
        Node help = null;
        while (fast != null) {
            help = fast.next;
            fast.next = slow;
            slow = fast;
            fast = help;
        }
        //此时慢指针已经指到了最后
        fast = node;
        //注意！此时还要记住尾巴的位置
        help = slow;
        boolean res = true;
        while (fast != null && slow != null) {
            if (fast.value != slow.value) {
                res = false;
                break;
            }
            fast = fast.next;
            slow = slow.next;

        }
        //最后反转链表
        slow = help.next;
        help.next = null;
        while (slow != null) {
            fast = slow.next;
            slow.next = help;
            help = slow;
            slow = fast;
        }
        return res;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node = null;
        node = new Node(1);
        node.next = new Node(1);
        printLinkedList(node);
        System.out.println(isPalindrome(node) + " | ");
        printLinkedList(node);
        System.out.println("=========================");

        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        printLinkedList(node);
        System.out.println(isPalindrome(node) + " | ");
        printLinkedList(node);
        System.out.println("=========================");

        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(1);
        printLinkedList(node);
        System.out.println(isPalindrome(node) + " | ");
        printLinkedList(node);
        System.out.println("=========================");

        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(1);
        printLinkedList(node);
        System.out.println(isPalindrome(node) + " | ");
        printLinkedList(node);
        System.out.println("=========================");

        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(2);
        node.next.next.next = new Node(1);
        printLinkedList(node);

        System.out.println(isPalindrome(node) + " | ");
        printLinkedList(node);
        System.out.println("=========================");

        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(1);
        printLinkedList(node);
        System.out.println(isPalindrome(node) + " | ");
        printLinkedList(node);
        System.out.println("=========================");
    }
}
