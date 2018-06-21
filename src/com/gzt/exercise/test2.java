package com.gzt.exercise;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * @author Administrator
 *
 */
public class test2 {
	// 时间复杂度O(n)
	public static int minNumberInRotateArray(int[] array) {

		if (array == null || array.length == 0) {
			return 0;
		} else {
			int min = 0;
			for (int i = 1; i < array.length; i++) {
				if (array[i] < array[min]) {
					min = i;
				}
			}
			return array[min];
		}
	}

	// 时间复杂度小于O(n)
	public static int minNumberInRotateArray2(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		} else {

			int low = 0;
			int hight = array.length - 1;
			while (low < hight) {
				// 如果数组没有旋转
				if (array[low] < array[hight]) {
					return array[low];
				}

				if (hight - low == 1) {
					return array[hight];
				}

				int mid = (low + hight) / 2;

				if (array[mid] >= array[low]) {
					low = mid;
				} else if(array[mid] <= array[low]) {
					hight = mid;
				}
			}
			return array[hight];
		}

	}

	public static void main(String[] args) {
		//int[] arr = new int[] { 3, 4, 5, 1, 2 };
		//int arr[] = {2,3,4,1,1,1,1};  
		int arr[] = {9,9,9,9,9,9,9,10,1,9}; 
		System.out.println(minNumberInRotateArray(arr));
	}
}
