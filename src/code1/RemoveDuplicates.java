package code1;

public class RemoveDuplicates {
	public static void removeDuplicates(int[] a){
		int count = 1;
		int length = a.length;
		for(int i = 1;i < length;i++){
			if(a[i] != a[i-1]){
				a[count++] = a[i];
			} 
		}
		for(int i = 0 ;i< count;i++){
			System.out.print(a[i]);
		}
	}
	public static void main(String[] args){
		int a[] = {0,1,1,2,3,4,4,5,5,5,6};
		RemoveDuplicates.removeDuplicates(a);
	}
}
