package code1;

import java.util.Scanner;

public class FindK {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		long x = in.nextLong();
		long k = in.nextLong();
		
		int count = 0 ;
		int sum = FindK.getZero(k);
		long y  = (int) (Math.log(k/sum)/Math.log(2));
		while(count != k){
			y++;
			if(or(x,y)){
				count++;
			}
		}
		System.out.print(y);
		
	}
	
	public static boolean or(long  str1,long  str2){
		if((str1 & str2) == 0){
			return true;
		} else {
			return false;
		}
	}
	public static int getZero(long str){
		int count = 0;
		while(str!=0){
			if((str&1)==0){
				count++;
			}
			str = str>>1;
		}
		return (int) Math.pow(2,count);
	}
}
