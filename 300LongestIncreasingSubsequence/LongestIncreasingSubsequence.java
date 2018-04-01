import java.util.*;
public class LongestIncreasingSubsequence{
	public static void main(String[] args){
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int res = lengthOfLIS(nums);
		System.out.println(res);
	}
	private static int lengthOfLIS(int[] nums){
		// return recursive_helper(Integer.MIN_VALUE, 0, nums);
		return dp_helper(nums);
	}


	private static int recursive_helper(int pre, int index, int[] nums){
		if(index == nums.length)
			return 0;
		else{
			int max = recursive_helper(pre, index + 1, nums);
			if(nums[index] > pre){
				max = Math.max(max, 1 + recursive_helper(nums[index], index+1, nums));
			}
			return max;
		}
	}

	private static int dp_helper(int[] nums){
		int n = nums.length;

		int[] LIS = new int[n];
		int res = 0;
		//num:[10, 9, 2, 5, 3, 7, 101, 18]
		//LIS:[1 , 1, 1, 2, 2, 3, 4  ,  4]
		for(int i = 0; i < n; i++){
			LIS[i] = 1;
			for(int j = 0; j < i; j++){
				if(nums[j] < nums[i])
					LIS[i] = Math.max(LIS[i], LIS[j]+1);
			}
			res = Math.max(res, LIS[i]);
		}
		System.out.println(Arrays.toString(LIS));
		return res;
	
	}
}