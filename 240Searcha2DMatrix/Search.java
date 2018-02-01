public class Search{
	public static void main(String[] args){
		// int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}};
		int[][] matrix = {{-5}};
		boolean res = searchMatrix2(matrix, -5);
		System.out.println(res);

	}
	public static boolean searchMatrix(int[][] matrix, int target){
		if(matrix.length == 0 || matrix[0].length == 0)
			return false;

		int right = matrix[0].length-1;
		for(int i = 0; i < matrix.length; i++){
			int flag = binarySearch(matrix[i], 0, right, target);
			if(flag == -2)
				return true;
			right = flag;
		}
		return false;

	}

	private static int binarySearch(int[] nums, int left, int right, int target){
		while(left <= right){
			int mid = (right-left)/2 + left;

			if(nums[mid] == target)
				return -2;
			else if(nums[mid] > target){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return right;
	}

	private static boolean searchMatrix2(int[][] matrix, int target){
		if(matrix.length == 0 || matrix[0].length == 0)
			return false;
		
		int row = 0, col = matrix[0].length-1;

		while(row < matrix.length && col >= 0){
			if(matrix[row][col] == target){
				return true;
			}
			else if(matrix[row][col] > target){
				col--;
			}else{
				row++;
			}
		}
		return false;
	}
}