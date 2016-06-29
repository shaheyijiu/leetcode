package code1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Revese {
	public static String reverseStr(String str){
		char[] strArray= str.toCharArray();
		int i = 0;
		int j = strArray.length - 1;
		while(i < j){
			char temp = strArray[j];
			strArray[j] = strArray[i];
			strArray[i] = temp;
			i++;
			j--;
		}
		String newStr = String.valueOf(strArray);
		return newStr;
	}
	public static String insertStr(String str,int n,String subStr){
		String s1 = str.substring(0, n);
		String s2 = str.substring(n,str.length());
		StringBuffer sb = new StringBuffer();
		String result = sb.append(s1).append(subStr).append(s2).toString();
		return result;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String str = in.next();
		int n = in.nextInt();
		int[] a = new int[2*n+1];
		a[0] = 0;
		for(int i = 1;i <= 2*n;i++){
			a[i] = in.nextInt();
		}
		for(int i = 1 ;i <= n;i++){
			String substr1 = str.substring(a[2*i-1],a[2*i-1]+a[2*i]);
			String reverstr = Revese.reverseStr(substr1);
			String resultstr = Revese.insertStr(str,a[2*i-1]+a[2*i],reverstr);
			str = resultstr;
		}
		System.out.println(str);

	}
}
