import java.util.*;

public class NQueens{
	public static void main(String[] args){
		int n = 1;
		List<List<String>> res = solveNQueens(n);
		System.out.println(res);

	}
	private static List<List<String>> solveNQueens(int n){
		List<List<String>> res = new ArrayList<>();
		if(n == 2)
			return res;
		recursion(res, new ArrayList<Integer>(), n);
		return res;
	}

	private static void recursion(List<List<String>> res, List<Integer> list, int n){
		if(list.size() == n){
			res.add(buildString(list, n));
		}else{
			for(int i = 0 ; i < n; i++){
				boolean legal = true;
				//check whether the index is legal
				for(int row = 0; row < list.size(); row++){
					if(list.get(row) == i || (Math.abs(list.size() - row) == Math.abs(list.get(row) - i))){
						legal = false;
					}
				}
				if(legal){
					list.add(i);
					recursion(res, list, n);
					list.remove(list.size()-1);	
				}
			}

		}
	}

	private static List<String> buildString(List<Integer> list, int n){
		List<String> slist = new ArrayList<>();
		for(int i: list){
			StringBuilder s = new StringBuilder();
			for(int j = 0; j < n; j++){
				if(j == i)
					s.append("Q");
				else
					s.append(".");
			}
			slist.add(s.toString());
		}
		return slist;
	}
}