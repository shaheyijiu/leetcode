package code1;
/**
 * 有重复值的二叉搜索
 * @author Administrator
 *
 */
public class SearchForARange {
	public static int[] searchRange(int a[],int target){
		int i = 0,j = a.length - 1;
		int[] result = new int[2];
		int mid = 0;
		while(i < j){
			mid = (i + j) / 2;
			if(a[mid] < target){
				i = mid +1;
			} else {
				j = mid;
			}
		}
		if(a[i] == target){
			result[0] = i;
		} else {
			result[0] = -1;
		}
		j = a.length - 1;
		while(i < j){
			mid = (i + j) /2 + 1;
			if(a[mid] > target){
				j = mid -1;
			} else {
				i = mid;
			}
		}
		if(a[j] == target){
			result[1] = j;
		} else {
			result[1] = -1;
		}
		return result;
	}
	public static void main(String[] args){
		int a[]= {5,7};
		int[] b = new int[2];
		b = searchRange(a,8);
		System.out.println(b[0]);
		System.out.println(b[1]);
	}

}
