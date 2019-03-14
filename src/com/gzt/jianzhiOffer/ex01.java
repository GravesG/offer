package com.gzt.jianzhiOffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class ex01 {
    public static boolean Find(int target, int [][] array) {
        int length = array[0].length;
        int hight = array.length;
        int curL = 0;
        int curR = length-1;

        while((curR >= 0 && curR <= length-1) && (curL >= 0 && curL <= hight - 1 )){
            if(array[curL][curR] < target){
                curL++;
            }else if(array[curL][curR] > target){
                curR--;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}
        };
        System.out.println(Find(8,arr));

    }
}
