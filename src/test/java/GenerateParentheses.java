package test.java;

import java.util.ArrayList;

public class GenerateParentheses {
	public static void generateParentheses(String result,int open,int close,int num,ArrayList<String> ans){
		if(open == num && close == num){
			ans.add(result);
			return;
		}
		if(open <= num){
			if(open < num){
				generateParentheses(result+"(",open+1,close,num,ans);
			}
			if(close < open){
				generateParentheses(result+")",open,close+1,num,ans);
			}
		}
	}
	public static void main(String[] args){
		String result = "";
		ArrayList<String> ans = new ArrayList<String>();
		generateParentheses(result,0,0,3,ans);
		for(int i = 0;i < ans.size();i++){
			System.out.println(ans.get(i));
		}
	}
}
