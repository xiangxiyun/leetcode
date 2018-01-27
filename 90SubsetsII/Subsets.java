import java.util.*;

public class Subsets{
	public static void main(String[] args){
		int[] nums = new int[]{2,1,2};
		List<List<Integer>> res = subsetsWithDup(nums);
		System.out.println(res);

	}
	//method 1
	private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] occupied = new boolean[nums.length];

        backtracking(res, new ArrayList<Integer>(), nums, occupied, 0);

        return res;

    }
    private static void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] occupied, int index){
    	res.add(new ArrayList<>(list));

    	for(int i = index; i < nums.length; i++){
    		if(i > 0 && nums[i] == nums[i-1] && !occupied[i-1])
    			continue;
    		list.add(nums[i]);
    		occupied[i] = true;
    		backtracking(res, list, nums, occupied, i+1);
    		list.remove(list.size()-1);
    		occupied[i] = false;
    	}
    }

    //method 2
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        backtracking(res, new ArrayList<Integer>(), nums, occupied, 0);

        return res;

    }
    private static void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
    	res.add(new ArrayList<>(list));

    	for(int i = index; i < nums.length; i++){
    		if(i > index && nums[i] == nums[i-1])
    			continue;
    		list.add(nums[i]);
    		backtracking(res, list, nums, i+1);
    		list.remove(list.size()-1);
    	}
    }
}