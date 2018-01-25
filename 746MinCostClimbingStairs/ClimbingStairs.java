public class ClimbingStairs{
	public static void main(String[] args){
		int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

		int res = minCostClimbingStairs(cost);
		System.out.println(res);

	}
	public static int minCostClimbingStairs(int[] cost){
		int len = cost.length+1;
		int[] sum = new int[len];
		sum[0] = 0;
		sum[1] = cost[0];

		for(int i = 2; i < len; i++){
			sum[i] = cost[i-1] + Math.min(sum[i-1], sum[i-2]);
		}

		return Math.min(sum[len-1], sum[len-2]);
	}
}