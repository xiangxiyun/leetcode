public class Power{
	public static void main(String[] args){
		double x = 2;
		int n = -2147483648;
		double res = myPow(x, n);
		System.out.println(res);
	}
	public static double myPow(double x, int n){
		System.out.print(x);
		System.out.print(" ");
		System.out.print(n);
		System.out.println();
		if(x == 0 || x == 1)
			return x;

		if(n == 0)
			return 1;

		if(n < 0){
			if(n == Integer.MIN_VALUE){
				return (1/x)*myPow(1/x, -(n+1));
			}
			return myPow(1/x, -n);
		}

		return (n%2 == 0? myPow(x*x, n/2): x*myPow(x*x, n/2));
	}
}