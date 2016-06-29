package code1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public static void fourSum(int[] nums,int num){
		ArrayList<List<Integer>> res = new ArrayList<>();
		int length = nums.length;
		Arrays.sort(nums);
		int max = nums[length-1];
		if(nums[0] * 4 > num || max * 4 < num){
			return;
		}
		for(int i = 0;i < length;i++){
			int z = nums[i];
			if(z > 0 && z == nums[i-1]) continue;
			if(z * 4 > num) break;
			if(4 * z == num){
				if((i + 3) < length && nums[i+3]==z){
					res.add(Arrays.asList(nums[i],nums[i],nums[i],nums[i]));
				} else {
					break;
				}
					
			} else {
				threesum(nums,i+1,length,num-z,res);
			}
		}
		for(int j = 0;j < res.size();j++){
			List<Integer> list = res.get(j);
			for(int m = 0;m < list.size();m++){
				System.out.print(list.get(m)+" ");
			}
			System.out.println();
		}
	}
	public static ArrayList<List<Integer>> threesum(int[] a,int start,int end,int target,ArrayList<List<Integer>> res){
		for(int i = start;i < end-1;i++){
			int left = i+1,right = end -1;
			while(left < right){
				//System.out.println("left="+left+" right="+right);
				if(a[left]+a[right]== (-a[i]+target)){
					res.add(Arrays.asList(a[start-1],a[i],a[left],a[right]));
					while(left<right && a[left] == a[left-1]) left++;
					while(left<right && a[right]== a[right-1]) right--;
					left++;
					right--;
				} else if(a[left]+a[right] < (-a[i]+target)) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}
	public static void main(String[] args){
		int a[] = {1,0,-1,0,-2,2};
		fourSum(a,0);
	}
}
