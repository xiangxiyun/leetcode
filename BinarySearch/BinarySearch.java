public class BinarySearch{
	//https://research.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6};
		int target = 4;

		int res = binarySearch(nums, target);
		System.out.println(res);

	}
	private static int binarySearch(int[] nums, int target){
		int low = 0;
		int high = nums.length;


		while(low <= high){
			int mid = (high - low)/2+low;
			if(nums[mid] > target){
				high = mid-1;
			}else if(nums[mid] < target){
				low = mid+1;
			}else{
				return mid;
			}
		}

		return -1;

	}
}