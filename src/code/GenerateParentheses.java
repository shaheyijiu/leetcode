package code;

import java.util.ArrayList;

public class GenerateParentheses {
	public void generateParentheses(String s,int open,int end,
			int num,ArrayList<String> ans){
		if(open == num && end == num){
			ans.add(s);
		}
		if(open < num){
			generateParentheses(s+"(",open+1,end,num,ans);
			if(end < open){
				generateParentheses(s+")",open,end+1,num,ans);
			}
		}
	}
}
