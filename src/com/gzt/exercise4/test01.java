package com.gzt.exercise4;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author Administrator
 *
 */
public class test01 {
	//此方法超时了
	/*public static int GetUglyNumber_Solution(int index) {
		if(index == 1){
			return 1;
		}
		int count = 1;
		int cur = 1;
		int temp=cur;
		while(count < index){
			if(cur%2 == 0){
				if(cur/2 == 1){
					count++;
					temp++;
					cur = temp;
				}else{
					cur = cur/2;
					if(cur == 0){
						temp++;
						cur = temp;
					}
				}
			}else if(cur%5 == 0){
				if(cur/5 == 1){
					count++;
					temp++;
					cur = temp;
				}else{
					cur = cur/5;
					if(cur == 0){
						temp++;
						cur = temp;
					}
				}
			}else if(cur%3 == 0){
				if(cur/3 == 1){
					count++;
					temp++;
					cur = temp;
				}else{
					cur = cur/3;
					if(cur == 0){
						temp++;
						cur = temp;
					}
				}
			}else{
				cur = ++temp;
			}
			
		}
        return cur-1;
    }*/
	
	public static int GetUglyNumber_Solution(int index) {
		if(index <=0 ){
			return 0;
		}
		int[] res = new int[index];
		int count = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		res[0] = 1;
		int temp = 0;
		while(count < index){
			temp = Math.min(res[i2]*2, Math.min(res[i3]*3, res[i5]*5));
			if(temp == res[i2]*2){
				i2++;
			}
			if(temp == res[i3]*3){
				i3++;
			}
			if(temp == res[i5]*5){
				i5++;
			}
			res[count++]=temp;
		}
		return res[count-1];
	}
	
	
	public static void main(String[] args) {
		long starTime=System.currentTimeMillis();
		System.out.println(GetUglyNumber_Solution(8));
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-starTime);
	}
}
