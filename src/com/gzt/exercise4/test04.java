package com.gzt.exercise4;

/**
 * 统计一个数字在排序数组中出现的次数。
 * @author Administrator
 *
 */
public class test04 {
	public static int GetNumberOfK(int [] array , int k) {
		if(array == null || array.length==0){
			return 0;
		}
		int first = getFirst(array,k,0,array.length-1);
		int last = getLast(array,k,0,array.length-1);
		if(first==-1 && last==-1){
			return 0;
		}
		return last-first+1;
    }
	public static int getFirst(int [] array , int k,int low,int hight){
		if(low > hight){
			return -1;
		}
		int mid = (low+hight)/2;
		int res = -1;
		if(array[mid] == k){
			if(mid == low){
				return mid;
			}
			if(array[mid-1] == k){
				hight = mid-1;
			}else{
				//此时array[mid-1]>k是不可能出现的，只有array[mid-1]<k的存在
				return mid;
			}
		}else if(array[mid] > k){
			hight = mid-1;
		}else{
			low = mid+1;
		}
		res = getFirst(array,k,low,hight);
		return res;
		
	}
	public static int getLast(int [] array , int k,int low,int hight){
		if(low > hight){
			return -1;
		}
		int mid = (low+hight)/2;
		int res = -1;
		if(array[mid] == k){
			if(mid == hight){
				return mid;
			}
			if(array[mid+1] == k){
				low = mid+1;
			}else{
				return mid;
			}
		}else if(array[mid] > k){
			hight = hight-1;
		}else{
			low = mid+1;
		}
		res = getLast(array,k,low,hight);
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,3,3,3,4,5};
		System.out.println(GetNumberOfK(arr,3));
	}
}
