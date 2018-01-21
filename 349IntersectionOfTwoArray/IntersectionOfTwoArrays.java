import java.util.*;

public class IntersectionOfTwoArrays{
	/*Given two arrays, write a function to compute their intersection.
	Note:
	Each element in the result must be unique.
	The result can be in any order.
	*/

	public static void main(String[] args){
		int[] nums1 = {1,2,3,4,5};
		int[] nums2 = {1,2,2,2,4};
		int[] res = intersection_two_pointers(nums1, nums2);
		for(int ele:res)
			System.out.println(ele);

	}
	public static int[] intersection_brute_force(int[] nums1, int[] nums2){
		/* brute force, this can be used on all the array */
		Set<Integer> intersection = new HashSet<>();

		for(int i:nums1){
			for (int j:nums2){
				if(i==j){
					// System.out.println(i);
					intersection.add(i);
					break;
				}
			}
		}

		int[] result = new int[intersection.size()];
		int i = 0;
		for(Integer num:intersection){
			result[i++] = num;
		}
		return result;
	}

	// public static int[] intersection_binary_search(int[] nums1, int[] nums2){
	// 	/*binary search, need to convert two arrays to sorted array */
		
	// }

	public static int[] intersection_two_pointers(int[] nums1, int[] nums2){
		/* only work on sorted array */
		int la = nums1.length, lb = nums2.length;
		int ia = 0, ib = 0;

		ArrayList<Integer> res = new ArrayList<>();

		while(ia < la && ib < lb){
			if(nums1[ia] < nums2[ib])
				ia++;
			else if(nums2[ib] < nums1[ia])
				ib++;
			else{ //nums1[ia] == nums2[ib]
				if((res.size() == 0) || res.get(res.size()-1) != nums1[ia]){
					res.add(nums1[ia]);
				}
				ia++;
				ib++;
			}
		}

		int[] r = new int[res.size()];
		for(int i = 0; i < res.size(); i++){
			r[i] = res.get(i);
		}

		return r;
	}
}