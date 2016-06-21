package test.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	private static List<ArrayList<Integer>> result = new ArrayList<>();
	public static void combinationSum(int a[],int target){
		Arrays.sort(a);
		//for(int i = 0;i < a.length;i++){
			ArrayList<Integer> list = new ArrayList<>();
			//list.add(a[i]);
			//System.out.println("mlIstÌí¼Ó"+a[i]);
			findValue(a,0,a.length-1,target,list);
		//}
	}
	public static void findValue(int a[],int start,int end,int target,ArrayList<Integer> list){
		if(target == 0){
			//result.add(list);
			result.add(new ArrayList(list));
			return;
		}
		if(target < 0){
			return;
		}
		
		for(int j = start;j <= end;j++){
			//int temp = target;
			if(j > start && a[j] == a[j-1]) continue;
			list.add(list.size(),a[j]);
			findValue(a,j+1,end,target-a[j],list);
			list.remove(list.size()-1);
			//target = temp;	
		}
	}
	public static void main(String[] args){
		int a[] = {10,1,2,7,6,1,5};
		combinationSum(a,8);
		for(int i = 0;i < result.size();i++){
			ArrayList<Integer> list = result.get(i);
			for(int j = 0;j < list.size();j++){
				System.out.print(list.get(j)+" ");
			}
			System.out.println();
		}
	}
}
