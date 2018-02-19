import java.util.*;

public class QuickSort{
	public static void main(String[] args){
		int[] nums = {3,2,4,1,3,4,7,6,5};
		quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));

	}

	public static void quickSort(int[] nums, int left, int right){
		int index = partition(nums, left, right);
		if(left < index-1)
			quickSort(nums, left, index-1);
		if(right > index)
			quickSort(nums, index, right);
	}

	private static int partition(int[] nums, int left, int right){
		int i = left, j = right;
		int pivot = nums[left + (right-left)/2];

		while(i <= j){
			while(nums[i] < pivot)
				i++;
			while(nums[j] > pivot)
				j--;

			if(i <= j){
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}
}