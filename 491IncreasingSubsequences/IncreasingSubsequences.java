import java.util.*;

public class IncreasingSubsequences{
	public static void main(String[] args){
		int[] nums = {4,5,4,5};
		List<List<Integer>> res = findSubsequences(nums);
		System.out.println(res);

	}
	public static List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		
		dfs(nums, 0, new ArrayList<Integer>(), res);
		
        return new ArrayList(res);
    }

    private static void dfs(int[] nums, int index, ArrayList<Integer> list, Set<List<Integer>> res){
    	if(list.size() > 1){
			res.add(new ArrayList<Integer>(list));
    	}

		for(int i = index; i < nums.length; i++){
			if((i == index)||(i > index && nums[i] != nums[i-1])){
				if(list.size() == 0 ||(list.size() > 0 && list.get(list.size()-1) <= nums[i])){
					list.add(nums[i]);
					dfs(nums, i+1, list, res);
					list.remove(list.size()-1);
				}
			}
		}

    }
}