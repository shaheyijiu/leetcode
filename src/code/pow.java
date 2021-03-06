package code;
/*
 * implement pow(x,n)
 * binary search
 */
public class pow {
	public double pow(double x,int n){
		if (n == 0) return 1;
		if(n < 0){
			n = -n;
			x = 1 / x;
		}
		return n % 2 == 0 ? pow(x*x,n/2):x*pow(x*x,n/2);
	}
	public static void main(String[] args){
		pow p = new pow();
		System.out.println(p.pow(2, 4));
	}
}
