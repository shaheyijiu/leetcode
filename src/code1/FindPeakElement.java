package code1;

public class FindPeakElement {
	public void findPeakElement(int[] nums){
		int length = nums.length-1;
		System.out.print(helper(nums,0,length));
	}
	public int helper(int[] nums,int start,int end){
		if(start == end){
			return start;
		} else if(start + 1 == end){
			if(nums[start] > nums[end]){
				return start;
			}
			return end;
			
		} else {
			int mid = start + (end - start) / 2;
			if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
				return mid;
			}else if(nums[mid-1] > nums[mid] && nums[mid] > nums[mid-1]){
				return helper(nums,start,mid - 1);
			}else {
				return helper(nums,mid+1,end);
			}
		}
	}
	public static void main(String[] args){
		int nums[] = {1,2,3,1};
		FindPeakElement f = new FindPeakElement();
		f.findPeakElement(nums);
	}
}
