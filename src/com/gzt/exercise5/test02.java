package com.gzt.exercise5;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author Administrator
 *
 */
public class test02 {
	public static String ReverseSentence(String str) {
		if(str == null || str.equals("")){
			return "";
		}
		if(str.equals(" ")){
			return "*"+str+"*";
		}
		String[] split = str.split(" ");
		int i=0;
		int j=split.length-1;
		while(i<j){
			String temp = split[i];
			split[i] = split[j];
			split[j] = temp;
			i++;
			j--;
		}
		StringBuffer res = new StringBuffer();
		for(int m=0;m<split.length;m++){
			res.append(split[m]);
			if(m!=split.length-1){
				res.append(" ");
			}
		}
		return res.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(ReverseSentence(" "));
	}
}
