package com.gzt.nowcoder;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
    private static Queue<Integer> queue;
    private static Queue<Integer> help;
    public QueueToStack(){
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }
    public static void push(int num){
        queue.add(num);
    }
    public static int peek(){
        if(queue.isEmpty()){
            throw new RuntimeException("stack is empty");
        }

        while(queue.size() != 1){
            help.add(queue.poll());
        }
        int res = queue.poll();
        help.add(res);
        //把两个队列应用交换
        swap();
        return res;
    }
    public static int poll(){
        if (queue.isEmpty()){
            throw  new RuntimeException("stack is empty");
        }

        while(queue.size() != 1){
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();
        return res;
    }

    public static void swap(){
        Queue<Integer> temp = help;
        help = queue;
        queue = temp;
    }

    public static void main(String[] args) {
        QueueToStack q = new QueueToStack();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
