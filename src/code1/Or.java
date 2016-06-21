package code1;

import java.util.Scanner;

public class Or {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int time = in.nextInt();
		int timeSum = in.nextInt();
		
		int result = 0;
		int singleNum = Or.getSingleNum(time, timeSum);
		System.out.println(singleNum);
		if(num % singleNum != 0){
			result = num / singleNum + 1;
		} else {
			result = num / singleNum;
		}
		System.out.println(result);
	}
	
	public static int getSingleNum(int time,int timeSum){
		int num = timeSum / time;
		while((num*time+num-1) > timeSum){
			num--;
		}
		if(num % 13 == 0){
			num--;
		}
		return num;
	}
}
