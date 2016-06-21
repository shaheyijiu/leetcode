package test.java;

import java.util.*;

public class Main {
    public String trans(String s, int n) {
        // write code here
    	char[] strArray = new char[n];
    	int end = strArray.length -1;
    	for(int i = 0;i <= end;i++){
        	strArray[i] =s.charAt(i);
        }
        int left = 0;
        int right = end;
        while(left < right){
        	char temp = strArray[left];
        	strArray[left] = strArray[right];
        	strArray[right] = temp;
        	left++;
        	right--;
        }
        for(int i = 0;i <= end;i++){
        	if(strArray[i] >= 'a' && strArray[i] <= 'z'){
        		strArray[i] -= 32;
        	} else if(strArray[i] >= 'A' && strArray[i] <= 'Z'){
        		strArray[i] += 32;
        	}
        }
        int flag = 0;
    	StringBuffer reuslt = new StringBuffer();
    	for(int i = 0;i <= end;i++){
    		if(strArray[i] == ' '){
    			int l = flag;
    	        int r = i-1;
    	        while(l < r){
    	        	char temp = strArray[l];
    	        	strArray[l] = strArray[r];
    	        	strArray[r] = temp;
    	        	l++;
    	        	r--;
    	        }
    	        flag = i+1;
    		}
    		if( i== end){
    			int l = flag;
    	        int r = i;
    	        while(l < r){
    	        	char temp = strArray[l];
    	        	strArray[l] = strArray[r];
    	        	strArray[r] = temp;
    	        	l++;
    	        	r--;
    	        }
    	        flag = i+1;
    		}
    	}
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i <= end;i++){
        	sb.append(strArray[i]);
        }
        
        return sb.toString();
    }
    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
    	//String str = in.next();
    	//int num = in.nextInt();
    	String str ="hell World";
    	int num = 10;
    	Main m = new Main();
    	String s = m.trans(str,num);
    	System.out.print(s);
    }
    
}