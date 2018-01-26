import java.util.*;

public class NQueens{
	public static void main(String[] args){
		int n = 4;
		int res = solveNQueens(n);
		System.out.println(res);

	}
	private static int solveNQueens(int n){
		int res = 0;
		if(n == 2)
			return res;
		res = recursion(new ArrayList<Integer>(), n);
		return res;
	}

	private static int recursion(List<Integer> list, int n){
		if(list.size() == n){
			return 1;
		}else{
			int sum = 0;
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
					sum += recursion(list, n);
					list.remove(list.size()-1);	
				}
			}
			return sum;
		}
	}
}