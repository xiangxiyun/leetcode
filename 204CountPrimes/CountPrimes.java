public class CountPrimes{
	/* Given an positive integer n, 
	return the number of all the primes 
	between 1 and that integer.
	Example:
	Input: 18
	Output: 7  //the primes are [2, 3, 5, 7, 11, 13, 17]

	Idea:
	1. Create a list of consecutive integers from 2 through n
	2. initially, let p equal 2, the smallest prime number
	3. Enumerate the multiples of p by counting to n from 2p in increments of p, 
		and mark them in the list as false;
	*/

	public static void main(String[] args){
		int res = countPrimes(3);

		System.out.print(res);

	}

	private static int countPrimes(int n){
		boolean[] a = new boolean[n+1];
		int count = 0;

		for(int i = 2; i <= n; i++){
			if(a[i] == false)
				count++;
			for(int j = 2; j*i <= n; j++){
				a[i*j] = true;
			}
		}

		// int[] res = new int[count];
		// for(int i = a.length-1; i > 1 ; i--){
		// 	if(a[i] == false){
		// 		// System.out.println(count);
		// 		// System.out.println(i);
		// 		res[--count] = i;

		// 	}

		// }

		return count;
	}
}