package code;

import java.util.ArrayList;

/**
 * You are given an integer array nums and you have to return a new counts array. 
 * The counts array has the property where counts[i] is the number of smaller 
 * elements to the right of nums[i].
 * Example:
 * Given nums = [5, 2, 6, 1]
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 * 
 */

public class CountOfSmallerNumbersAferSelf {
	public void countSmaller(int[] nums){
		Integer[] ans = new Integer[nums.length];
		ArrayList<Integer> sorted = new ArrayList<>();
		for(int i = nums.length-1;i >=0;i--){
			int index = findIndex(sorted,nums[i]);
			ans[i] = index;
			sorted.add(index,nums[i]);
		}
	}
	
	public int findIndex(ArrayList<Integer> sorted,int target){
		if(sorted.size() == 0) return 0;
		if(sorted.get(0) > target) return 0;
		if(sorted.get(sorted.size()-1) < target) 
			return sorted.size();
		int start = 0,end = sorted.size()-1;
		while(start < end){
			int mid = (start + end) / 2;
			if(sorted.get(mid) < target){
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		return start;
	}
}
