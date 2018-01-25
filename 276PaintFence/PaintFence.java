public class PaintFence{
	public static void main(String[] args){
		int n = 3, k = 3;

		int res = numWays(n, k);

		System.out.println(res);

	}
	private static int numWays(int n, int k){
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
		// int[] same = new int[n];
		int[] diff = new int[n];

		// same[0] = same[1] = k;
		diff[0] = k;
		diff[1] = k*(k-1) + diff[0];

		for(int i = 2; i < n; i++){
			//same[i] = diff[i-1];
			//diff[i] = (k-1)*(same[i-1] + diff[i-1]);

			/* replace same array with diff array*/

			diff[i] = (k-1)*(diff[i-1] + diff[i-2]);
		}

		return diff[n-1];
	}
}