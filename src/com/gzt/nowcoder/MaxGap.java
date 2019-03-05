package com.gzt.nowcoder;

public class MaxGap {
    public static int maxGap(int[] nums){
        if(nums == null || nums.length <2 ){
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //找到该数组的最大值和最小值
        for(int i=0;i<len;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if(min == max){
            return 0;
        }

        //创建桶
        boolean[] hasNum = new boolean[len+1];
        int[] mins = new int[len+1];
        int[] maxs = new int[len+1];

        //把每个数放入对应的桶里
        int bucketId = 0;
        for(int i=0;i<len;i++){
            bucketId = bucket(nums[i],len,min,max);
            mins[bucketId] = hasNum[i] ? Math.min(nums[i],mins[bucketId]) : nums[i];
            maxs[bucketId] = hasNum[i] ? Math.max(nums[i],maxs[bucketId]) : nums[i];
            hasNum[bucketId] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for(;i<=len;i++){
            if(hasNum[i]){
                res = Math.max(res,mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(int num,int len,int min,int max){
        return (int) (num - min)*len/(max - min);
    }

    public static void main(String[] args) {
        int[] nums = {11,13,35,45};
        System.out.println(maxGap(nums));
    }
}
