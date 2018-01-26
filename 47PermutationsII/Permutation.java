import java.util.*;

public class Permutation{
	public static void main(String[] args){
		int[] nums = new int[]{3,3,0,3};
		
		List<List<Integer>> res = permutationUnique(nums);
		System.out.println(res);

	}

	public static List<List<Integer>> permutationUnique(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		boolean[] ocuppied = new boolean[nums.length];
		recursion(nums, new ArrayList<Integer>(), res, ocuppied);
		return res;
	}

	private static void recursion(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] ocuppied){
		if(list.size() == nums.length){
			res.add(new ArrayList<Integer>(list));
		}else{
			for(int i = 0; i < nums.length; i++){
				if(ocuppied[i] || (i > 0 && (nums[i] == nums[i-1] && !ocuppied[i-1] )))
					continue;
				
				// System.out.println("as");
				list.add(nums[i]);
				ocuppied[i] = true;
				recursion(nums, list, res, ocuppied);
				ocuppied[i] = false;
				list.remove(list.size()-1);
			}
		}

	}
}