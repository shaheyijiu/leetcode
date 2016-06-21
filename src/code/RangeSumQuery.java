package code;
/**
 * Given an integer array nums, find the sum of the elements 
 * between indices i and j (i ¡Ü j), inclusive.The update(i, val)
 *  function modifies nums by updating the element at index i 
 *  to val. 
 *  Example: 
 *  Given nums = [1, 3, 5]
 *  sumRange(0, 2) -> 9 
 *  update(1, 2) 
 *  sumRange(0, 2) -> 8 
 *  Note: 
 *  The array is only modifiable by the update function. 
 *  You may assume the number of calls to update and sumRange 
 *  function is distributed evenly.
 */
public class RangeSumQuery {
	int nums[];
	int[] BIT;
	int length;
	
	public void numRange(int[] nums){
		this.nums = nums;
		length = nums.length;
		BIT = new int[length+1];
		for(int i = 0;i < length;i++){
			init(i,nums[i]);
		}
	}
	public void init(int id,int val){
		id++;
		while(id <= length){
			BIT[id] += val;
			id += (id & -id);
		}
	}
	public void update(int id,int val){
		int diff = val - nums[id];
		nums[id] = val;
		id++;
		while(id <= length){
			BIT[id] += diff;
			id += (id & -id);
		}
	}
	
	public int getSum(int id){
		int sum = 0;
		id++;
		while(id > 0){
			sum += BIT[id];
			id -= (id & -id);
		}
		return sum;
	}
	public int getSum(int start,int end){
		if(start == 0){
			return getSum(end);
		} else{
			return getSum(end) - getSum(start -1);
		}
		
	}
	public static void main(String[] args){
		RangeSumQuery r = new RangeSumQuery();
		int num[] = {1,3,5};
		r.numRange(num);
		System.out.println(r.getSum(0,2));
		r.update(1,2);
		System.out.println(r.getSum(0,2));
	}
}















