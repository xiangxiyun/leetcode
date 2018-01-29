import java.util.*;

public class CombinationSum{
	public static void main(String[] args){
		int[] candidates = new int[]{2,3,6,7};
		int target = 7;
		List<List<Integer>> res = combinationSum(candidates, target);
	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>>res = new ArrayList<>();
		Array.sort(candidates);
		backtracking(res, new ArrayList<Integer>(), candidates, target, 0);
		System.out.println(res);
		return res;
    }

    private static void backtracking(List<List<Integer>>res, List<Integer> list, int[] candidates, int remain, int start){
    	if(remain == 0)
    		res.add(new ArrayList<>(list));
    	else if(remain < 0)
    		return;
    	else{
    		for(int i = start; i < candidates.length; i++){
    			// if(remain-candidates[i] < 0)
    			// 	break;
    			list.add(candidates[i]);
    			backtracking(res, list, candidates, remain-candidates[i],i); // start from i because we can use a number multiple times
    			list.remove(list.size()-1);
    		}
    	}
    }
}