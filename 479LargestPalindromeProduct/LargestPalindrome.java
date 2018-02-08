public class LargestPalindrome{
	public static void main(String[] args){

		for(int i = 1; i < 9; i++){
			int res = largestPalindrome(i);
			System.out.println(res);	
		}		


		
		// System.out.println(res);
	}
	private static int largestPalindrome(int n){	
		if(n == 1){
			return 9;
		}
		int upperBound = (int)Math.pow(10, n) -1, lowerBound = (int)Math.pow(10,n-1);
		// System.out.println(upperBound);
		long maxnum = (long) upperBound * (long) upperBound;
		// System.out.println(maxnum);

		int firsthalf = (int)(maxnum / (long)Math.pow(10, n));
		
		boolean find = false;
		long palidrome = 0;
		// palidrome = buildPalidrome(firsthalf);
		// System.out.println(palidrome);

		while(!find){
			palidrome = buildPalidrome(firsthalf);
			
			for(long i = upperBound; i >= lowerBound; i--){
				if(palidrome/i > upperBound || i*i < palidrome)
					break;

				if(palidrome%i == 0){
					find = true;
					break;
				}
			}
			firsthalf--; 
		}
		return (int)(palidrome%1337);

	}

	private static long buildPalidrome(int firsthalf){
		int secondhalf = 0, n = firsthalf;
		long f = (long)firsthalf;
		while(n!= 0){
			secondhalf = secondhalf*10 + n%10;
			f *= 10;
			n /= 10;
		}

		return f+(long)secondhalf;
	}
}