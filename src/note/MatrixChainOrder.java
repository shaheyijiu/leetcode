package note;
//矩阵Ai的维数为Pi-1Pi
//m[i][j]表示AiAi+1..Aj相乘所需最小次数
//采用由底自上的动态规划
public class MatrixChainOrder{
	public final static int N = 6;
	
	public static void main(String[] args){
		int[] p = new int[]{30,35,15,5,10,20,25}; 
		int[][] m = new int[N+1][N+1];
		int[][] s = new int[N+1][N+1];
		MatrixChain(p,m,N,s);
		System.out.println(m[1][N]);
	} 
	
	public static void MatrixChain(int[] p,int m[][],int N,int s[][]){
		for(int i = 0;i <= N;i++){
			m[i][i] = 0;
		}
		for(int t = 2;t <= N;t++){//当前链乘矩阵的长度
			for(int i = 1;i <= N-t+1;i++){//从第一矩阵开始算起，计算长度为t的最少代价
				int j = i+t-1;//长度为t的矩阵链的最后一个矩阵
				m[i][j] = Integer.MAX_VALUE;
				for(int k = i;k <= j-1;k++){//寻找最优的k值，使得分成两部分k在i与j-1之间
					int temp = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					if(temp < m[i][j]){
						m[i][i+t-1] = temp;//记录下当前的最小代价
						s[i][i+t-1] = k;
					}
				}
			}
		}
	}
}