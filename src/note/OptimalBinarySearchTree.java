package note;

//c[i][j]:节点I到j的期望值
//r[i][j]:节点I到j的根
//参考网址:http://www.cnblogs.com/Anker/archive/2013/03/13/2958488.html
public class OptimalBinarySearchTree {
	
	public static void searchTreeWithoutFailure(double c[][],int r[][],int num,double p[]){
		for(int i = 1;i <= num;i++){
			c[i][i] = p[i];
			c[i][i-1] = 0;
			r[i][i] = i;
		}
		for(int t = 1;t <= num;t++){
			for(int i = 1;i <= num-t+1;i++){
				int j = i+t-1;
				c[i][j] = Double.MAX_VALUE;
				int kmin = 0;
				for(int k = i;k <= j;k++){
					double temp = 0;
					if(k == j){
						temp = c[i][k-1];
					} else {
						temp = c[i][k-1] + c[k+1][j];
					}
					if(temp < c[i][j]){
						c[i][j] = temp;
						kmin = k;
					}
				}
				r[i][j] = kmin;
				double sum = 0;
				for (int m = i;m <= j ;m++){
					sum += p[m];
				}
				c[i][j] = c[i][j] + sum;
				
			}
		}
	}
		public static void main(String[] args){
			double p[] = {0,0.22,0.18,0.20,0.05,0.25,0.02,0.08};
			//double p[] = {0,0.22,0.18};
			int num = p.length;
			double[][] c = new double[num][num];
			int[][] r = new int[num][num];
			searchTreeWithoutFailure(c,r,num-1,p);
			System.out.println(c[1][7]);
		}
}
