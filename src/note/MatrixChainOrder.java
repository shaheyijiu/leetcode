package note;
//����Ai��ά��ΪPi-1Pi
//m[i][j]��ʾAiAi+1..Aj���������С����
//�����ɵ����ϵĶ�̬�滮
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
		for(int t = 2;t <= N;t++){//��ǰ���˾���ĳ���
			for(int i = 1;i <= N-t+1;i++){//�ӵ�һ����ʼ���𣬼��㳤��Ϊt�����ٴ���
				int j = i+t-1;//����Ϊt�ľ����������һ������
				m[i][j] = Integer.MAX_VALUE;
				for(int k = i;k <= j-1;k++){//Ѱ�����ŵ�kֵ��ʹ�÷ֳ�������k��i��j-1֮��
					int temp = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					if(temp < m[i][j]){
						m[i][i+t-1] = temp;//��¼�µ�ǰ����С����
						s[i][i+t-1] = k;
					}
				}
			}
		}
	}
}