import java.util.*;

public class Solution{
	/* bittiger Array -- Delete Duplicates from a Sorted Array*/

	public static void main(String[] args){
		int[] nums = {2,3,5,5,7,11,11,11,13};
		int res = removeDuplication2(nums);
		System.out.println(res);
		for(int i:nums){
			System.out.print(i);
			System.out.print(' ');
		}
		System.out.print('\n');

	}

	private static int removeDuplication(int[] nums){
		/* Time complexity: O(n) 
		* Space complexity: O(n)
		*/

		if(nums.length == 0)
			return 0;

		ArrayList<Integer> a = new ArrayList<Integer>();
        int pre = nums[0];
        a.add(pre);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != pre){
                a.add(nums[i]);
                pre = nums[i];
            }
        }

        for(int i = 1; i < nums.length; i++){
        	if(i < a.size())
        		nums[i] = a.get(i);
        	else
        		nums[i] = 0;
        }


        return a.size();
	}

	private static int removeDuplication2(int[] nums){
		/* Time complexity: O(n) 
		* Space complexity: O(1)
		*/
		if(nums.length == 0 || nums == null)
			return 0;

		int count = 1;


        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[count] = nums[i];
                count++;
            }
        }
        for(int i = count; i < nums.length; i++){
        	nums[i] = 0;
        }
        return count;
	}

}