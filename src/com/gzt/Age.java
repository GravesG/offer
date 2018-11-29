package com.gzt.code2;

/**
 * 某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。
 *
 * 现在算起来，他一共吹熄了236根蜡烛。
 *
 * 请问，他从多少岁开始过生日party的？
 *
 * 请填写他开始过生日party的年龄数。
 */
public class Age {
    public static void main(String[] args) {
        //人的一生也就100岁
        for (int i = 1; i <100 ; i++) {
            int s = 0;
            for(int j=i;j<100;j++){
                s+=j;
                if(s==236){
                    System.out.println(i);
                }
            }
        }
    }
}
