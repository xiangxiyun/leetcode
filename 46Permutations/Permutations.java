import java.util.*;

public class Permutations{
	public static void main(String[] args){
		int[] nums = new int[]{1,2,3};
		List<List<Integer>> res = permute(nums);
		System.out.println(res);
	}
	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new ArrayList<>();

		int len = nums.length;
		boolean[] flag = new boolean[len];
		List<Integer> list = new ArrayList<>();
		recursion(list, nums, flag, res);
		
		return res;
	} 

	public static void recursion(List<Integer> list, int[] nums, boolean[] flag, List<List<Integer>> res){
		if(list.size() == nums.length){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = 0; i < nums.length; i++){
			if(flag[i] != true){
				list.add(nums[i]);
				flag[i] = true;
				recursion(list, nums, flag, res);
				flag[i] = false;
				list.remove(list.size()-1);
			}
		}
	}
}