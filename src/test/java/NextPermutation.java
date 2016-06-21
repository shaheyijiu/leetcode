package test.java;

public class NextPermutation {
	public void nextPermutation(int nums[]){
		int length = nums.length;
		int index = length-1;
		while(index > 0){
			if(nums[index-1] < nums[index])
				break;
			index--;
		}
		if(index == 0){
			swapAll(nums,0,length-1);
			return;
		}
		int j = length -1;
		while(j >= index){
			if(nums[j] > nums[index-1]){
				break;
			}
			j--;
		}
		swap(nums,j,index-1);
		swapAll(nums,index,length-1);
	}
	public void swap(int nums[],int i,int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public void swapAll(int nums[],int i,int j){
		int len = nums.length;
		while(i < j){
			swap(nums,i++,j--);
		}
	}
	
	public static void main(String[] args){
		int a[] ={1,1,5};
		NextPermutation n = new NextPermutation();
		n.nextPermutation(a);
		for(int i= 0;i < a.length;i++){
			System.out.print(a[i]);
		}
	}

}
