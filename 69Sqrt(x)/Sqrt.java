public class Sqrt{
	public static void main(String[] args){
		int x = 0;
		int res = mySqrt(x);
		System.out.println(res);

	}
	private static int mySqrt(int x){

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