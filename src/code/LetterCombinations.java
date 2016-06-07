package code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class LetterCombinations {
	private static String[] orders = new String[]{"0","1","abc","def","ghi","jkl",
		"mno","pqrs","tuv","wxyz"};
	private static ArrayList<String> ans = new ArrayList<String>();
	
	public static void output(String intput,String result){
		if(intput.length() == 0){
			String temp = result;
			ans.add(result);
			return;
		}
		char[] a = intput.toCharArray();
		String s = orders[Integer.parseInt(String.valueOf(a[0]))];
		for(int i = 0;i < s.length();i++){
			result = result + s.charAt(i);
			output(intput.substring(1,intput.length()),result);
			result = result.substring(0, result.length()-1);
		}
	}
	
	public static void main(String[] args){
		output("23","");
		for(int i = 0;i < ans.size();i++){
			System.out.println(ans.get(i));
		}
	}
}
