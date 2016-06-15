package code;

public class MinimumSizeSubarraySum {
	public void minSubArray(int target,int[] nums){
		System.out.println(solveN(target,nums));
	}
	public int solveN(int s,int nums[]){
		int i = 0,length = nums.length;
		int min = Integer.MAX_VALUE;
		//int[] sum = new int[length];
		int sum = 0;
		while(i < length){
			sum += nums[i];
			i++;
			int temp = sum,j = 0;
			while(temp >= s){
				min = Math.min(min, i-j);
				temp = temp - nums[j];
				j++;
			}
		}
		if(min == Integer.MAX_VALUE){
			min = 0;
		}
		return min;
	}
	
//	public int solveNLogN(int s,int[] nums){
//		
//	}
//	public int binarySearch(int lo,int hi,int key,int nums){
//		
//	}
	public static void main(String[] args){
		MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
		int[] a = {1,2,3,4,5,6};
		m.minSubArray(100, a);
	}

}
