package com.gzt.nowcoder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//宽搜
public class BFS {
    public static void bfs(Node node) {
        if(node == null){
            return ;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        ((LinkedList<Node>) queue).add(node);
        set.add(node);
        while(!queue.isEmpty()){
            Node cur = ((LinkedList<Node>) queue).pop();
            System.out.println(cur.value);
            for(Node help : cur.nexts){
                if(!set.contains(help)){
                    ((LinkedList<Node>) queue).add(help);
                    set.add(node);
                }
            }
        }
    }
}
