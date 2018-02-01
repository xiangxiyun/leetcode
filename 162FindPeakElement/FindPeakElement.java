public class FindPeakElement{
	public static void main(String[] args){
		int[] nums = {3,2,1};
		int res = findPeakElement(nums);
		System.out.println(res);

	}
	private static int findPeakElement(int[] nums){
		for(int i = 0; i < nums.length-1; i++){
			if(nums[i] > nums[i+1])
				return i;
		}
		return nums.length-1;
	}

	private static int findPeakElement_bs(int[] nums){

		int left = 0, right = nums.length-1;
		while(left < right){
			int mid = (right-left)/2 + left;
			int mid2 = mid+1;
			if(nums[mid] > nums[mid2])
				right = mid;
			else{
				left = mid2;
			}
		}
		return right;
	}
}