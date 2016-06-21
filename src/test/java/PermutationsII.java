package test.java;

import java.util.ArrayList;

/**
 * 全排列问题，今天看到微博上有人说清华的研究生复试上机试题有一道全排列问题，貌似学生们回答的不好。
 * 想起以前在leetCode上面也刷过全排列问题，就又重新AC了一次。
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]
 * @author Administrator
 *
 */
public class PermutationsII {
	
	public void permutation(int nums[]){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<>();
		permute(nums,0,path,ans);
		for(int i = 0;i < ans.size();i++){
			ArrayList<Integer> list = ans.get(i);
			for(int j= 0;j < list.size();j++){
				System.out.print(list.get(j));
			}
			System.out.println();
		}
		
	}
	public void permute(int nums[],int start,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> ans){
		if(start == nums.length){
			ArrayList<Integer> list = new ArrayList<>(path);
			ans.add(list);
			return;
			
		}
		if(start >= 1 && nums[start] == nums[start-1]){
			ArrayList<Integer> list = new ArrayList<>(path);
			list.add(list.size(),nums[start]);
			//System.out.println("s");
			permute(nums,start+1,list,ans);
			
		} else {
			for(int i = 0;i <= start;i++){
				ArrayList<Integer> list = new ArrayList<>(path);
				list.add(i,nums[start]);
				//System.out.println("y");
				permute(nums,start+1,list,ans);
			}
		}
		
	}
	public static void main(String[] args){
		PermutationsII p = new PermutationsII();
		int a[] = {1,1,2};
		p.permutation(a);
	}
}

