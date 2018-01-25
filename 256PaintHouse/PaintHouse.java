public class PaintHouse{
	public static void main(String[] args){
		int[][] costs = new int[][]{{1,2,3},{2,2,1},{2,1,3}};
		int res = minCost(costs);
		System.out.println(res);

	}
	public static int minCost(int[][] costs){
        if(costs.length == 0)
            return 0;
		int lastA = costs[0][0];
		int lastB = costs[0][1];
		int lastC = costs[0][2];


		for(int i = 1; i < costs.length; i++){
			int curA = Math.min(lastB, lastC) + costs[i][0];
			int curB = Math.min(lastA, lastC) + costs[i][1];
			int curC = Math.min(lastA, lastB) + costs[i][2];
			lastA = curA;
			lastB = curB;
			lastC = curC;
		}

		return Math.min(Math.min(lastA, lastB), lastC);
	}
}