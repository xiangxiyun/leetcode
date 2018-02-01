public class Sqrt{
	public static void main(String[] args){
		int x = 8;
		int res = mySqrt(x);
		System.out.println(res);

	}
	private static int mySqrt(int x){
		if(x == 0)
			return 0;

		int left = 1, right = x;
		while(left <= right){
			int mid = left + (right-left)/2;
			if(mid == x/mid){
				return mid;
			}
			else if(mid > x/mid){
				right = mid - 1;
			}
			else{
				left = mid + 1;
			}
		}
		return right;
	}
}