package test.java;

public class Find {
	public static void main(String[] args){
		int x = 10;
		int k = 4;
		System.out.print(Find.getY(x, k));
		
	}
	
	public static  int getY(int x,int k){
		int count = 0;
		for(int i = 1;i < 1000;i++){
			if((x + i)==(x | i)){
				count++;
			}
			if(count == k){
				return i;
			}
		}
//		if((x + k)== (x | k)){
//			return 1;
//		}
		return 0 ;
	}
}
