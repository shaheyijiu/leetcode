package code;

public class sqrt {
	public int sqrt(int x){
		if(x == 0){
			return 0;
		}
		int left = 0,right = x;
		while(left < right){
			int mid = left + (right - left) / 2;
			if(mid * mid > x){
				right = mid - 1;
			} else {
				if((mid+1) * (mid+1) > x){
					return mid;
				}
				left = mid + 1;
			}
		}
		return 0;
	}
	
}
