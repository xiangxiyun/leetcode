import java.util.*;

public class Subsets{
	public static void main(String[] args){
		int[] nums = new int[]{1,2,3};
		List<List<Integer>> res = subsets(nums);

		System.out.println(res);

	}
	private static List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);

		backtracking(res, new ArrayList<Integer>(), nums, 0);

		return res;
	}

	private static void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
		res.add(new ArrayList<>(list));

		for(int i = index; i < nums.length; i++){
			list.add(nums[i]);
			backtracking(res, list, nums, i+1);
			list.remove(list.size()-1);
		}
	}
}