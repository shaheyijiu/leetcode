package code;

/*
 * Divide two integers without using multiplication, division 
 * and mod operator.
 */
public class DivideTwoIntegers {
	public int divide(int divided,int divisor){
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}
		int flag = (divided < 0) ^ (divisor < 0) ? -1:1; 
		int dvd = Math.abs(divided);
		int dvr = Math.abs(divisor);
		if(dvd < dvr){
			return 0;
		}
		int result = 0;
		int temp = dvr;
		int remain = dvd;
		while(remain >= dvr){
			int count = 1;
			temp = temp << 1;
			while((dvd -temp) >= 0){
				temp = temp << 1;
				count = count << 1;
			}
			result += count;
			remain = dvd - (temp >> 1);
			temp = dvr;
			dvd = remain;
		}
		
		return result;	
	}
	public static void main(String[] args){
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println(d.divide(20, 3));
	}

}
