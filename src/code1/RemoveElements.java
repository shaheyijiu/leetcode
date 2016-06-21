package code1;

public class RemoveElements {
	public static void removeElement(int a[],int value){
		int length = a.length;
		int count = 0;
		for(int i = 0;i < length;i++){
			if(a[i] != value){
				a[count++] = a[i];
			}
		}
		for(int i = 0;i < count;i++){
			System.out.print(a[i]);
		}
	}
	public static void main(String[] args){
		int a[] = {4,4,4,6};
		RemoveElements.removeElement(a,4);
	}
}
