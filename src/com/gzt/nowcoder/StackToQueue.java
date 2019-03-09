package com.gzt.nowcoder;

import java.util.Stack;

public class StackToQueue {
    private static Stack<Integer> pushStack;
    private static Stack<Integer> popStack;

    public StackToQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void dao() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public void push(int num) {
        if (!popStack.isEmpty()) {
            throw new RuntimeException("error operation");
        }
        pushStack.push(num);
    }

    public int poll() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        dao();
        return popStack.pop();
    }

    public int peek() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        dao();
        return popStack.peek();
    }

    public static void main(String[] args) {
        StackToQueue s = new StackToQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.poll());
        System.out.println(s.peek());
        System.out.println(s.poll());
        System.out.println(s.poll());
        System.out.println(s.poll());

    }
}
