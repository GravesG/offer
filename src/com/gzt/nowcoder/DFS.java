package com.gzt.nowcoder;

import java.util.HashSet;
import java.util.Stack;

//深搜
public class DFS {
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        //添加进来就输出
        System.out.println(node.value);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for(Node help : cur.nexts){
                if(!set.contains(help)){
                    stack.add(cur);
                    stack.add(help);
                    set.add(help);
                    System.out.println(help.value);
                    break;
                }
            }
        }
    }
}
