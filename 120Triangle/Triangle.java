import java.util.*;

public class Triangle{
	public static void main(String[] args){

	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int r = triangle.size();

		int m = triangle.get(r-1).size();
		int[] res = new int[m];

		for(int c = 0; c < m; c++)
			res[c] = triangle.get(r-1).get(c);

		for(int i = r-2; i >= 0; i--){
			List<Integer> temp = triangle.get(i);
			for(int c = 0; c < temp.size(); c++){
				res[c] =temp.get(c) + Math.min(res[c], res[c+1]);
			}
		}
        return res[0];
    }ßß
}