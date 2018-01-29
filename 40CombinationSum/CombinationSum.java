import java.util.*;

public class CombinationSum{
	public static void main(String[] args){
		int[] candidates = new int[]{2,2,3,7};
		int target = 1;
		List<List<Integer>> res = combinationSum2(candidates, target);
		System.out.println(res);

	}

	private static List<List<Integer>> combinationSum2(int[] candidates, int target){
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		backtracking(res, new ArrayList<Integer>(), candidates, target, 0);
		return res;
	}

	private static void backtracking(List<List<Integer>> res, List<Integer> list, int[] candidates, int remain, int start){
		if(remain == 0)
			res.add(new ArrayList<Integer>(list));
		else if(remain < 0)
			return;
		else{
			for(int i = start; i < candidates.length; i++){
				if(i>start && candidates[i] == candidates[i-1])
					continue;
				list.add(candidates[i]);
				backtracking(res, list, candidates, remain-candidates[i], i+1);
				list.remove(list.size()-1);
			}
		}
	}
}