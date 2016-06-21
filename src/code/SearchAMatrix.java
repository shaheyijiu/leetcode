package code;

import java.util.ArrayList;

public class SearchAMatrix {
	public boolean search(int target,ArrayList<ArrayList<Integer>> matrix){
		int m = matrix.size();
		if(m == 0) return false;
		int n = matrix.get(0).size();
		int left = 0,right = m * n - 1;
		while(left < right){
			int mid = left + (right - left) / 2;
			int row = mid / n,line = mid % n;
			int value = matrix.get(row).get(line);
			if(value < target){
				left = mid + 1;
			} else {
				if(value == target){
					return true;
				}
				right = mid - 1;
			}
		}
		return false;
	}
}
