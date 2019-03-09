package com.gzt.nowcoder;

import java.util.Stack;

public class PreInPosTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preTree(Node head){
        if(head == null){
            return ;
        }
        System.out.print(head.value + " ");
        preTree(head.left);
        preTree(head.right);
    }

    public static void inTree(Node head){
        if(head == null){
            return ;
        }
        inTree(head.left);
        System.out.print(head.value + " ");
        inTree(head.right);
    }

    public static void posTree(Node head){
        if(head == null){
            return ;
        }
        posTree(head.left);
        posTree(head.right);
        System.out.print(head.value + " ");
    }

    public static void preTree2(Node head){
        if(head == null){
            return ;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.print(cur.value + " ");
            if(cur.right != null){
                stack.add(cur.right);
            }
            if(cur.left != null){
                stack.add(cur.left);
            }
        }
    }

    public static void inTree2(Node head){
        if(head == null){
            return ;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null){
            if(head != null){
                stack.add(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }

    public static void posTree2(Node head){
        if(head == null){
            return ;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.add(head);
        while (!stack1.isEmpty()){
            head = stack1.pop();
            stack2.add(head);
            if(head.left != null){
                stack1.add(head.left);
            }
            if(head.right != null){
                stack1.add(head.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().value + " ");
        }
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        preTree(head);
        System.out.println();
        inTree(head);
        System.out.println();
        posTree(head);
        System.out.println();
        preTree2(head);
        inTree2(head);
        posTree2(head);
    }
}
