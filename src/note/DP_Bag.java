package note;

import java.util.ArrayList;

/**
 * �б�ŷֱ�Ϊa,b,c,d,e�������Ʒ�����ǵ������ֱ���2,2,6,5,4�����ǵļ�ֵ
 * �ֱ���6,3,5,4,6�����ڸ��������Ϊ10�ı���������ñ�����װ�����Ʒ�������
 * �ļ�ֵ�ܺͣ�
 * name	weight	value	1	2	3	4	5	6	7	8	9	10
	a		2		6	0	6	6	9	9	12	12	15	15	15
	b		2		3	0	3	3	6	6	9	9	9	10	11
	c		6		5	0	0	0	6	6	6	6	6	10	11
	d		5		4	0	0	0	6	6	6	6	6	10	10
	e		4		6	0	0	0	6	6	6	6	6	6	6
 * @author Administrator
 * {@link}http://blog.csdn.net/mu399/article/details/7722810
 *
 */
public class DP_Bag {
	public int dp(ArrayList<BagItem> bag,int totalWeight){
		int length = bag.size();
		int[][] bagMatrix = new int[length][totalWeight+1];
		for(int i = 0;i < length;i++){
			bagMatrix[i][0] = 0;
		}
		for(int i = 1;i <= totalWeight;i++){
			for(int j = length-1;j >= 0;j--){
				if(i < bag.get(j).getWeight()){
					//�����������ڱ�������
					if(j == length-1){
						bagMatrix[j][i] = 0;
					} else {
						bagMatrix[j][i] = bagMatrix[j+1][i];
					}
					
				} else {
					if(j == length-1){
						bagMatrix[j][i] = bag.get(j).getValue();
					} else {
						int temp = bagMatrix[j+1][i-bag.get(j).getWeight()]
								+ bag.get(j).getValue();
						bagMatrix[j][i] = Math.max(temp, bagMatrix[j+1][i]);
					}
				}
 			}
		}
		return bagMatrix[0][totalWeight];
		//return bag.get(1).getWeight();
		
	}
	
	public static void main(String[] args){
		BagItem b1 = new BagItem(2,6);
		BagItem b2 = new BagItem(2,3);
		BagItem b3 = new BagItem(6,5);
		BagItem b4 = new BagItem(5,4);
		BagItem b5 = new BagItem(4,6);
		ArrayList<BagItem> bag = new ArrayList<>();
		bag.add(b1);
		bag.add(b2);
		bag.add(b3);
		bag.add(b4);
		bag.add(b5);
		DP_Bag d = new DP_Bag();
		System.out.println(d.dp(bag, 7));
		//System.out.println(bag.get(0).getWeight());
	}
}

class BagItem{
	private int weight;
	private int value;
	public BagItem(int weight,int value){
		this.weight = weight;
		this.value = value;
	}
	public void setWeight(int weight){
		this.weight = weight;
	}
	public int getWeight(){
		return weight;
	}
	public int getValue(){
		return value;
	}
	
}
