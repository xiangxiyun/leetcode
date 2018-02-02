public class FindMin{
	public static void main(String[] arg){
		int[] nums = {0,1,2,3,4,5};
		int res = findMin(nums);
		System.out.println(res);

	}
	public static int findMin(int[] nums){
		int left = 0, right = nums.length-1;

		while(left < right){
			// System.out.println(left);
			// System.out.println(right);
			// System.out.println("");
			int mid = (right - left)/2 + left;
			
			if(nums[mid] < nums[right]){
				right = mid;
			}else{
				left = mid+1;
			}
		}

		return nums[right];

	}
}