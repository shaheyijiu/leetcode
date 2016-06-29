package code1;
/*
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard such that no two queens 
 * attack each other.
 * iven an integer n, return all distinct solutions to the n-queens puzzle.

	Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' 
	both indicate a queen and an empty space respectively.
	For example,
	There exist two distinct solutions to the 4-queens puzzle:
	[
 	[".Q..",  // Solution 1
  		"...Q",
  		"Q...",
  		"..Q."],

 	["..Q.",  // Solution 2
  		"Q...",
  		"...Q",
  		".Q.."]
	]
 */
import java.util.ArrayList;

public class NQueens {
	public void nQueen(int n){
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		ArrayList<String> path = new ArrayList<>();
		for(int i = 0;i < n;i++){
			execute(ans,path,0,i,n);
		}
		for(int i = 0;i < ans.size();i++){
			ArrayList<String> list = ans.get(i);
			for(int j = 0;j < list.size();j++){
				System.out.print(list.get(j));
			}
			System.out.println();
		}
	}
	public void execute(ArrayList<ArrayList<String>> ans,ArrayList<String> path,int row,int line,int n){
		if(row == n){
			ans.add(new ArrayList<>(path));
			return;
		}
		if(!isValid(path,row,line)){
			return;
		} else {
			path.add(getString(line,n));
			for(int i = 0;i < n;i++){
				if(row == n-1){
					execute(ans,path,row+1,i,n);
					break;
				} else {
					execute(ans,path,row+1,i,n);
				}
			}	
			path.remove(path.size()-1);
		}
		
		
	}
	
	public boolean isValid(ArrayList<String> path,int row,int line){
		for(int i = 0;i < path.size();i++){
			String s = path.get(i);
			int line1 = s.indexOf("Q");
			if(i == row || line1 == line){
				return false;
			}
			if((row - i) == Math.abs(line - line1)){
				return false;
			}
		}
		return true;
	}
	
	public String getString(int line,int n){
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < line;i++){
			sb.append(".");
		}
		sb.append("Q");
		for(int i = line+1;i < n;i++){
			sb.append(".");
		}
		return sb.toString();
	}

	public static void main(String[] args){
		NQueens n = new NQueens();
		n.nQueen(4);
	}
}
