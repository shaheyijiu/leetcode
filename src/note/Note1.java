package note;

import java.util.ArrayList;
/**
 * �����ظ�ֵ��������ж�����������
 * ֮ǰ�Ķ������������붼����ֵ��
 *���硾2,3,3,3��4�����롰3��������Ϊ��2����3����3,3,3,4��
 *������ǰ��
 * @author Administrator
 *
 */
public class Note1 {
	public void countSmaller(int[] nums){
		ArrayList<Integer> sorted = new ArrayList<>();
		for(int i = nums.length-1;i >=0;i--){
			int index = findIndex(sorted,nums[i]);
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
