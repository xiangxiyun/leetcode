public class MedianofTwoArrays{
	public static void main(String[] args){

	}
	public static double findMedian(int[] nums1, int[] nums2){
		int m = nums1.length;
		int n = nums2.length;

		if(m > n)
			return findMedian(nums2, nums1);

		int imin = 0, imax = m;

		while(imin <= imax){
			i = (imin+imax)/2;
			j = (m+n+1)/2 - i;

			if(i > 0 && nums1[i-1] > nums2[j]){
				imax = i-1;
			}else if(i < m && nums2[j-1]>nums1[i]){
				imin = i+1;
			}else
			break;
		}

		int max_of_left, min_of_right;
		if(i == 0) max_of_left = nums2[j-1];
		else if(j==0) max_of_left = nums1[i-1];
		else max_of_left = Math.max(nums1[i-1], nums2[j-1]);

		if((m+n)%2 == 1) return max_of_left;

		if(i == m) min_of_right = nums2[j];
		else if(j == n) min_of_right = nums1[i];
		else min_of_right = Math.min(nums1[i], nums2[j]);

		return (max_of_left+min_of_right)/2.0;
	}
}