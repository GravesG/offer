package com.gzt.nowcoder;

public class PaperFolding {

    public static void printAllFlolds(int N){
        printProcess(1,N,true);
    }

    public static void printProcess(int i,int N,boolean down){
        if(i > N){
            return ;
        }
        printProcess(i+1,N,true);
        System.out.println(down ? "down" : "false");
        printProcess(i+1,N,false);
    }

    public static void main(String[] args) {
        printAllFlolds(4);

    }
}
