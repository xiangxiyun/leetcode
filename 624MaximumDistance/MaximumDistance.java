import java.util.*;

public class MaximumDistance{
	public static void main(String[] args){
		List<List<Integer>> arrays = new ArrayList<>();

		arrays.add(new ArrayList<Integer>(Arrays.asList(1,4)));
		arrays.add(new ArrayList<Integer>(Arrays.asList(0,5)));
		// arrays.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));

		int res = maxDistance(arrays);

		System.out.println(res);

	}
	private static int maxDistance(List<List<Integer>> arrays){
		int min = arrays.get(0).get(0);
		int max = arrays.get(0).get(arrays.get(0).size()-1);

		int res = Integer.MIN_VALUE;
		for(int i = 1; i < arrays.size(); i++){
			res = Math.max(res, Math.abs(max-arrays.get(i).get(0)));
			res = Math.max(res, Math.abs(arrays.get(i).get(arrays.get(i).size()-1) - min));
			max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
			min = Math.min(min, arrays.get(i).get(0));
		}

		return res;
	}
	private static int maxDistance_pq(List<List<Integer>> arrays){
		PriorityQueue<int[]> ascending = new PriorityQueue<>( 
			new Comparator<int[]>(){
				
				public int compare(int[] a, int[] b){
					if(a[0] > b[0])
						return 1;
					else if(a[0] == b[0])
						return 0;
					else
						return -1;
				}
			});
		PriorityQueue<int[]> descending = new PriorityQueue<>(
			new Comparator<int[]>(){
				public int compare(int[] a, int[] b){
					if(a[0] < b[0])
						return 1;
					else if(a[0] == b[0])
						return 0;
					else
						return -1;
				}
			});

		for(int i = 0; i < arrays.size(); i++){
			List<Integer> cur = arrays.get(i);
			ascending.add(new int[]{cur.get(0), i});
			descending.add(new int[]{cur.get(cur.size() - 1), i});
		}

		if(ascending.peek()[1]!= descending.peek()[1])
			return Math.abs(descending.peek()[0]-ascending.peek()[0]);
		else{
			int[] s = ascending.poll();
			int[] l = descending.poll();
			return Math.max(Math.abs(descending.peek()[0]-s[0]), Math.abs(l[0]-ascending.peek()[0]));
		}

	}
}