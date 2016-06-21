package test.java;

import java.util.Arrays;

public class MedianOfTwoSortedArray {
	public static int getkth(int a[],int m,int b[],int n,int k){
		if(m < n){
			return getkth(b,n,a,m,k);
		}
		if( m == 0){
			return b[k-1];
		}
		if(k == 1){
			return Math.min(a[0],b[0]);
		}
		int i = Math.min(m, k/2);
		int j = k /2;
		if(a[i-1] > b[j-1] ){
			int[] newArray = new int[n-j+1];
			newArray = Arrays.copyOfRange(b, j, n-j+1);
			return getkth(a,m,newArray,n-j,k-j);
		} else {
			int[] newArray = new int[n-j+1];
			newArray = Arrays.copyOfRange(a, i, m-i+1);
			return getkth(newArray,m-i,b,n,k-i);
		}
	}
	public static double getMedian(int a[],int m,int b[],int n){
		int l = ( m + n + 1)>>1;
		int r = (m + n + 2)>>1;
		return (double)((MedianOfTwoSortedArray.getkth(a, m, b, n, l) + 
				MedianOfTwoSortedArray.getkth(a, m, b, n, r)) / 2.0);
	}
	public static void main(String[] args){
		int a[] = {1,3,6,7};
		int b[] = {2,4,5,8,9,10};

		System.out.print(MedianOfTwoSortedArray.getMedian(a,a.length,b,b.length));
	}
}
