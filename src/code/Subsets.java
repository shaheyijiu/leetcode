package code;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * Given a set of distinct integers,  S , return all possible subsets.

	Note: 
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example, 
	If  S  =  [1,2,3] , a solution is:

	[
  		[3],
  		[1],
  		[2],
  		[1,2,3],
  		[1,3],
  		[2,3],
  		[1,2],
  		[]
	]
 */
public class Subsets {
	public void subset(int nums[]){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<>();
		Arrays.sort(nums);
		int length = nums.length;
		getSubset(ans,path,0,length-1,nums);
		for(int i = 0;i < ans.size();i++){
			ArrayList<Integer> list = ans.get(i);
			for(int j = 0;j < list.size();j++){
				System.out.print(list.get(j));
			}
			System.out.println();
		}
	}
	
	public void getSubset(ArrayList<ArrayList<Integer>> ans,
			ArrayList<Integer> path,int start,int end,int[] nums){
		if(start > end){
			return;
		}
		for(int i = start;i <= end;i++){
			path.add(nums[i]);
			ArrayList<Integer> list = new ArrayList<>(path);
			ans.add(list);
			getSubset(ans,path,i+1,end,nums);
			path.remove(path.size()-1);
			
		}
		
	}
	public static void main(String[] args){
		Subsets s = new Subsets();
		int[] nums = {1,2,3};
		s.subset(nums);
	}
}
