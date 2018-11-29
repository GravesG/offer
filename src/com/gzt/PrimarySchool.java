package com.gzt.code2;

public class PrimarySchool {
    static int sum = 0;
    static int[] a = new int[13];
    static boolean[] bol = new boolean[14];

    public static void dfs(int x){
        if(x>=13){
            return;
        }
        if(x==3&&a[0]+a[1]!=a[2]){
            return;
        }
        if(x==6&&a[3]-a[4]!=a[5]){
            return;
        }
        if(x==9&&a[6]*a[7]!=a[8]){
            return;
        }
        if(x==12){
            if(a[11]*a[10]==a[9]){
                sum++;
            }
        }
        for (int i = 1; i <= 13 ; i++) {
            if(!bol[i]){
                bol[i] = true;
                a[x] = i;
                dfs(x+1);
                bol[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        dfs(0);
        System.out.println(sum);
    }
}
