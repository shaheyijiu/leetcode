package code;

public class JumpGame {
	 public int jump(int[] nums){
			int length = nums.length;
			int max = nums[0];
		
			int jump = 1,pos = 0;
			while(max < length-1 & jump < length){
				jump++;
				int temp = max;
				for(int i = pos+1;i <= temp;i++){
					if(i+nums[i] > max){
						max = nums[i]+i;
						pos = i;
					}
				}
			}
	        if(jump == length){
	            return 0;//防止出现{0,0,0}这种测试用例
	        }
			return jump;
		}
	public static void main(String[] args){
		JumpGame j = new JumpGame();
		int[] nums = {2,3,1,1,4,5};
		System.out.println(j.jump(nums));
	}
}
