import java.util.*;

public class TwoSum{
	public static void main(String[] args){
		int[] nums = {2,7,11,15};
		int target = 9;

		int[] res = twoSum(nums, target);

		System.out.println(Arrays.toString(res));

	}
	private static int[] twoSum(int[] nums, int target){
		/*
		go through the list once O(n);
		it actually o(nlogn), logn is time find the element or insert the element to the map;
		*/
		int[] res = new int[2];
		HashMap<Integer, Integer> table = new HashMap<>();
		for(int i = 0 ; i < nums.length; i++){
			int remainder = target - nums[i];
			if(!table.containsKey(remainder)){
				table.put(nums[i], i);
			}else{
				res[0] = table.get(remainder);
				res[1] = i;
			}
		}
		return res;

	}
}