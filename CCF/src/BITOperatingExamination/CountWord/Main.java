//website：http://tk.hustoj.com/problem.php?id=2065
//2065: 单词识别
//时间限制: 1 Sec  内存限制: 32 MB
//提交: 124  解决: 9
//[提交][状态][下载(1元)]
//题目描述
//输入一个英文句子，把句子中的单词(不区分大小写)按出现次数按从多到少把单词和次数在屏幕上输出来，要求能识别英文句号和逗号，即是说单词由空格、句号和逗号隔开。
//
//输入
//输入有若干行，总计不超过1000个字符。
//
//输出
//输出格式参见样例。
//
//样例输入
//A blockhouse is a small castle that has four openings through which to shoot.
//样例输出
//a:2
//blockhouse:1
//castle:1
//four:1
//has:1
//is:1
//openings:1
//shoot:1
//small:1
//that:1
//through:1
//to:1
//which:1



package BITOperatingExamination.CountWord;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner (System.in) ;
    
    public static void main(String[] args) {
    	while(s.hasNext()){
    		String str = s.nextLine() ;
    		
    		str = str.replaceAll("\\,", "").replaceAll("\\.", "").toLowerCase() ;
    		String strs[] = str.split("\\s+") ;//\\s表示 空格,回车,换行等空白符,
    		Arrays.sort(strs) ;
    		for (int i = 0; i < strs.length; i++) {
    			int sum = 1 ;
    			for (int j = i+1; j < strs.length; j++) { 
    				if(strs[i].equals(strs[j])){
    					sum++ ;
    					strs[j]="" ;//  remove the same string
    				}
    				
    			}
    			if(strs[i].length()>0)
    			    System.out.println(strs[i]+":"+sum);
    		}
    		
    	}
		
	}
}
