import java.util.*;
/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

For example, given array S = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

public class threeSum{
	public static void main(String[] args){
		int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = threeSum(nums);

		for(List<Integer> l:res)
			System.out.println(l);

	}
	public static List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);

		int n = nums.length;
		for(int i = 0; i < n-2; i++){
			if(i == 0 || nums[i] != nums[i-1]){
				int low = i+1, high = n-1, target = 0 - nums[i];
				while(low < high){
					if(nums[low] + nums[high] < target)
						low++;
					else if(nums[low] + nums[high] > target)
						high--;
					else{
						res.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
						while(low < high && nums[low-1] == nums[low])
							low++;
						while(low < high && nums[high+1] == nums[high])
							high--;
					}
				}
			}

		}
		return res;
	}

}