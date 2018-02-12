import java.util.*;

public class CountingBits{
	public static void main(String[] args){
		int num = 5;
		int[] res = countBits(num);

		System.out.println(Arrays.toString(res));

	}
	private static int[] countBits(int num){
		int[] res = new int[num+1];
		if(num == 0)
			return res;
		res[1] = 1;
		for(int i = 2; i <= num; i++){
			res[i] = res[i>>1] + (i&1);
			//res[i] = res[i/2] + (i%2);
		}
		return res;


	}
}