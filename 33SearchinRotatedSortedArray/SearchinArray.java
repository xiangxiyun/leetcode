public class SearchinArray{
	public static void main(String[] args){
		int[] nums = {4,5,6,7,0,1,2};
		int target = 5;
		int res = search(nums, target);
		System.out.println(res);

	}

	private static int search(int[] nums, int target){
		int n = nums.length;
		int left = 0, right = n-1;

		while(left < right){
			int mid = (right-left)/2 + left;
			if(nums[mid] < nums[right]){
				right = mid;
			}
			else{
				left = mid+1;
			}
		}

		int rot = right;
		left = 0; right = n-1;

		while(left <= right){
			int mid = (right-left)/2 + left;
			int realmid = (mid + rot)%n;

			if(nums[realmid] == target)
				return realmid;
			if(nums[realmid] < target) left = mid+1;
			else right = mid-1;
		}
		return -1;
		
    }
}