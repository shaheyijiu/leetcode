package code;

/*****************************************
 * 给定一个数组，找出里面的3个数的和正好等于给定的一个值
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ThreeSumCloset {
	public static void getResult(int a[],int num){
		Arrays.sort(a);
		List<List<Integer>> list = new ArrayList<>();
		int min = Math.abs(a[0] + a[1] + a[a.length-1] - num);
		list.add(Arrays.asList(a[0],a[1],a[a.length-1]));
		for(int i= 0;i < a.length;i++){
			int left = i+1,right = a.length-1;
			while(left < right){
				if(a[left]+a[right]==(-a[i]+num)){
					list.clear();
					System.out.println("I1="+i+" left="+left + " right="+right);
					list.add(Arrays.asList(a[i],a[left],a[right]));
					break;
				}
				if(a[left]+a[right]<(-a[i]+num)){
					if(Math.abs(a[i] + a[left] + a[right] - num) < min){
						list.clear();
						System.out.println("I2="+i+" left="+left + " right="+right);
						list.add(Arrays.asList(a[i],a[left],a[right]));
					}
					left++;
					
				
				} else {
					if(Math.abs(a[i] + a[left] + a[right] - num) < min){
						list.clear();
						System.out.println("I3="+i+" left="+left + " right="+right);
						list.add(Arrays.asList(a[i],a[left],a[right]));
					}
					right--;
					
				}
			}
		}
		for(int j = 0;j  <list.size();j++){
			List<Integer> myList = list.get(j);
			for(int i =0 ;i < myList.size();i++){
				System.out.println(myList.get(i));
			}
		}
		
	}
	public static void main(String[] args){
		int[] s = new int[]{-1,2,1,4};
		ThreeSumCloset.getResult(s, 4);
	}

}
