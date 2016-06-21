package test.java;

public class FirstMissingPositive {
	public static int getFirstMissingPositive(int a[],int length){
		for(int i = 0;i < length;i++){
			while(a[i] > 0 && a[i] <= length && a[i] != (i+1)){
				int temp = a[i];
				a[i] = a[temp-1];
				a[temp-1] = temp;
			}
		}
		int j = 0;
		while(j < length && a[j] == j+1){
			j++;
		}
		return a[j-1]+1;
	}
	public static void main(String[] args){
		int a[] = {3,4,-1,1};
		System.out.print(getFirstMissingPositive(a,4));
	}

}
