package code;
/*
 * 求字典序的下一个数
 */
public class NextPermutation {
	public static int[] getNextPermutation(int[] a){
		int length = a.length;
		int temp;
		int index = length -1;
		while(index>0 && a[index]<a[index-1]){
			index--;
		}
		if(index == 0){
			reverse(a,0,length-1);
			return a;
		} 
		int j = length-1;
		while(a[j] < a[index-1]){
			j--;
		}
		swap(a,index-1,j);
		reverse(a,index,length-1);
		return a;
		 
	}
/***************java版的数组的两个值交换*******************/
	public static void swap(int[] num,int i,int j){
		int temp = 0;
		temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	public static void reverse(int[] a,int left,int right){
		int temp = 0;
		while(left < right){
			temp = a[left];
			 a[left] = a[right];
			 a[right] = temp;
		}
	}
	public static void main(String[] args){
		int a[]={1,1,5};
		int[] b = NextPermutation.getNextPermutation(a);
		for(int m = b.length-1;m>= 0;m--){
			System.out.println(b[m]);
		 }
	}
	
}
