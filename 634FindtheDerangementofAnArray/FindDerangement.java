public class FindDerangement{
	/*
	A derangement is a permutation of the elements of a set, 
	such that no element appears in its original position.
	https://en.wikipedia.org/wiki/Derangement#Counting_derangements
	*/
	public static void main(String[] args){
		int n = 3;
		System.out.println(findDerangement(n));
	}
	private static int findDerangement(int n){
		long d0 = 1, d1 = 0;
		long res = n == 1?0:1;
		// start from !2
		for(int i = 2; i <= n; i++){
			res = (i-1)*(d1 + d0)%1000000007;
			d0 = d1;
			d1 = res;
		}
		return (int) res;
	}
}