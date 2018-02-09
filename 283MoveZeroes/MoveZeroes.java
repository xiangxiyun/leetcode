import java.util.*;

public class MoveZeroes{
	public static void main(String[] args){
		int[] nums = {0,1,0,3,12};

		moveZeroes(nums);

		System.out.println(Arrays.toString(nums));

	}
	private static void moveZeroes(int[] nums){
		int p = 0;

		for(int i = 0; i < nums.length; i++){
			if(nums[i] != 0){
				nums[p] = nums[i];
				p++;
			}
		}
		while(p < nums.length){
			nums[p] = 0;
			p++;
		}

	}
}