package code1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*****************************************************************
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 ********************************************************************/
public class ThreeSum {
	public static ArrayList<List<Integer>> threesum(int[] a){
		Arrays.sort(a);
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 0;i < a.length-1;i++){
			int left = i+1,right = a.length -1;
			while(left < right){
				//System.out.println("left="+left+" right="+right);
				if(a[left]+a[right]== -a[i]){
					result.add(Arrays.asList(a[i],a[left],a[right]));
					while(left<right && a[left] == a[left-1]) left++;
					while(left<right && a[right]== a[right-1]) right--;
					left++;
					right--;
				} else if(a[left]+a[right] < -a[i]) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		int[] a = new int[]{-1,0,1,2,-1,-4};
		ArrayList<List<Integer>> list = ThreeSum.threesum(a);
		for(int i = 0;i < list.size();i++){
			List<Integer> mList = list.get(i);
			for(int j = 0;j < mList.size();j++){
				System.out.print(mList.get(j)+" ");
			}
			System.out.println();
		}
	}
}
