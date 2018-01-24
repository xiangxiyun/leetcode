public class MaximumProductSubarray{
	public static void main(String[] args){
		int[] nums = new int[]{-3, 0, 1, -2};

		int res = maxProduct(nums);

		System.out.println(res);
	}

	public static int maxProduct(int[] nums){

		int mp = nums[0];

		for(int i = 1, imax = mp, imin = mp; i < nums.length; i++){
			if(nums[i] < 0){
				int t = imax;
				imax = imin;
				imin = t;
			}
			imax = Math.max(nums[i], imax*nums[i]);
			imin = Math.min(nums[i], imin*nums[i]);

			mp = Math.max(mp, imax);
		}

		return mp;
	}
}