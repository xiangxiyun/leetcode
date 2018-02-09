public class Fibonacci{
	public static void main(String[] args){
		int n = 7;
		int res = fibo_recursive(n);
		System.out.println(res);
	}
	private static int fibo_iterate(int n){
		/*iterate method*/
		int f1 = 0, f2 = 1;
		if(n < 3){
			return n == 1? 0:1;
		}
		for(int i = 3; i <=n; i++){
			int temp = f1 + f2;
			f1 = f2;
			f2 = temp;
		}
		return f2;
	}
	private static int fibo_recursive(int n){
		if(n == 1)
			return 0;
		if(n == 2)
			return 1;
		else return fibo_recursive(n-1) + fibo_recursive(n-2);
	}


}