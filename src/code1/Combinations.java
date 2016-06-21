package code1;

import java.util.ArrayList;

/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

	For example,
	If n = 4 and k = 2, a solution is:
	
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
 */
public class Combinations {
	public void combinate(int k,int n){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<>();
//		for(int i = 1;i <= n;i++){
//			execute(path,ans,1,i,n,k);
//		}
		execute(path,ans,1,1,n,k);
		System.out.println(ans.size());
		for(int i = 0;i < ans.size();i++){
			ArrayList<Integer> list = ans.get(i);
			for(int j = 0;j < list.size();j++){
				System.out.print(list.get(j));
			}
			System.out.println();
		}

	}
	public void execute(ArrayList<Integer> path,ArrayList<ArrayList<Integer>> ans,int count,int start,int n,int k){
		if(count == k+1){
			ArrayList<Integer> list = new ArrayList<>(path);
			//System.out.println(list.get(0));
			ans.add(list);
			return;
		}
		if(start > n){
			return;
		}
		for(int i = start;i <= n;i++){
			path.add(i);
			execute(path,ans,count+1,i+1,n,k);
			path.remove(path.size()-1);
		}
	}
	
	public static void main(String[] args){
		Combinations c = new Combinations();
		c.combinate(2, 4);
	}
}
