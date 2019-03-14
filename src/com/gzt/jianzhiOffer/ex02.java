package com.gzt.jianzhiOffer;

public class ex02 {
    public static String replaceSpace(StringBuffer str) {
        String result = str.toString();
        if(result.contains(" ")){
            while(str.indexOf(" ") != str.lastIndexOf(" ")){
                int index = str.indexOf(" ");
                str.replace(index,index+1,"%20");
            }
            int index = str.indexOf(" ");
            str.replace(index,index+1,"%20");
            result=str.toString();
            return result;
        }else{
            return result;
        }
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(str.lastIndexOf(" "));
        String res = replaceSpace(str);
        System.out.println(res);
    }
}
