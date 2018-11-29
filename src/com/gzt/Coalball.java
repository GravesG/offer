package com.gzt.code2;

/**
 * 有一堆煤球，堆成三角棱锥形。具体：
 * 第一层放1个，
 * 第二层3个（排列成三角形），
 * 第三层6个（排列成三角形），
 * 第四层10个（排列成三角形），
 * ....
 * 如果一共有100层，共有多少个煤球？
 */
public class Coalball {
    public static int findSum(int n){
        if(n==1){
            return 1;
        }
        //总数
        int num = 0;
        int s = 0;
        for(int i=1;i<=n;i++){
            s+=i;
            num+=s;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(findSum(100));
    }
}
