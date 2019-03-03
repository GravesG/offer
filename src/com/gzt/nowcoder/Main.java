package com.gzt.nowcoder;

import java.util.Scanner;

public class Main {

    static boolean t = true;

    public static boolean method(int N, int A, int B, int C) {
        if (N == 0) {
            return true;
        }
        //有c的情况
        if (C > 0) {
            if (C >= 2) {
                C = C - 2;
                N--;
                t = method(N, A, B, C);
            } else if (C == 1 && B >= 1 && A >= 1) {
                C = C - 1;
                B = B - 1;
                A = A - 1;
                N--;
                t = method(N, A, B, C);
            } else {
                t = false;
            }
        } else {
            //B的情况
            if (B > 0) {
                if (B >= 3) {
                    B = B - 3;
                    N--;
                    t = method(N, A, B, C);
                } else if (B == 2 && A >= 2) {
                    B = B - 2;
                    A = A - 2;
                    N--;
                    t = method(N, A, B, C);
                } else if (B == 1 && A >= 4) {
                    B = B - 1;
                    A = A - 4;
                    N--;
                    t = method(N, A, B, C);
                } else {
                    t = false;
                }
            } else {
                if (A >= 6) {
                    A = A - 6;
                    N--;
                    t = method(N, A, B, C);
                } else {
                    t = false;
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(~Long.MAX_VALUE);
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] arr = new int[n][4];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 4; j++) {
//                {//注意while处理多个case
//                    arr[i][j] = sc.nextInt();
//                }
//            }
//        }
//        for (int k = 0; k < arr.length; k++) {
//            // System.out.println(arr[k][0]+"-"+arr[k][1]+"-"+arr[k][2]+"-"+arr[k][3]);
//            boolean flag = method(arr[k][0], arr[k][1], arr[k][2], arr[k][3]);
//            if (flag) {
//                System.out.println("Yes");
//            } else {
//                System.out.println("No");
//            }
//        }

    }
}
