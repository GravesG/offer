package com.gzt.nowcoder;

public class Matrix1 {
    public static void print(int[][] m){
        int row1 = 0;
        int col1 = 0;
        int row2 = m.length-1;
        int col2 = m[0].length-1;
        while (row1 <= row2 && col1 <= col2){
            pringEdge(m,row1++,col1++,row2--,col2--);
        }
    }

    public static void pringEdge(int[][] m,int row1,int col1,int row2,int col2){
        if(row1 == row2) {
            for (int i = col1; i <= col2; i++) {
                System.out.println(m[row1][i]);
            }
        }else if (col1 == col2){
            for (int j = row1; j <= row2; j++){
                System.out.println(m[j][col1]);
            }
        }else{
            int curR = row1;
            int curC = col1;
            while (curC < col2){
                System.out.println(m[row1][curC++] + " ");
            }
            while (curR < row2){
                System.out.println(m[curR++][col2] + " ");
            }
            while (curC > col1){
                System.out.println(m[row2][curC--] + " ");
            }
            while (curR > row1){
                System.out.println(m[curR--][col1] + " ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        print(matrix);

    }
}
