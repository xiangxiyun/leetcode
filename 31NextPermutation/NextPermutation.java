public class NextPermutation{
	public static void main(String[] args){
		int[] nums = new int[]{2,4,3};
		nextPermutation(nums);

		for(int i : nums)
			System.out.println(i);

	}
	private static void nextPermutation(int[] nums){
		boolean flag = false;
		int len = nums.length;
		int index = len-1;
		while(index > 0){
			if(nums[index] > nums[index-1])
				break;
			index--;
		}
		if(index == 0){
			reverseSort(nums, 0, len-1);
			return;
		}else{
			int hold = nums[index-1];
			int j = len-1;
			while(j >= index){
				if(nums[j] > hold)
					break;
				j--;
			}
			nums[index-1] = nums[j];
			nums[j] = hold;
			reverseSort(nums, index, len-1);
		}
	}

	private static void reverseSort(int[] nums, int begin, int end){
		if(end < begin)
			return;

		// reverse the descending array
		for(int i = begin; i <= (end+begin)/2; i++){
			int hold = nums[i];
			nums[i] = nums[begin+end-i];
			nums[begin+end-i] = hold;
		}
		
	}

}