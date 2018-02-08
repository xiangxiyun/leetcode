import java.util.*;

public class ContainsDuplicate{
	/*https://discuss.leetcode.com/topic/14730/possible-solutions*/
	public static void main(String[] args){
		int[] nums = {};
		boolean res = containsDuplicate(nums);
		System.out.println(res);

	}
	public static boolean containsDuplicate(int[] nums){
		HashSet<Integer> set = new HashSet<>();

		for(int i = 0; i < nums.length; i++){
			if(set.contains(nums[i]))
				return true;
			else
				set.add(nums[i]);
		}
		return false;
	}
}