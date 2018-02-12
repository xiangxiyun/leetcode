public class RegularExpressionMatching{
	public static void main(String[] args){
		String s = "aasdf";
		String p = "aasdf.*";
		boolean res = isMatch(s, p);

		System.out.println(res);
	}

	private static boolean isMatch(String s, String p){
		int sl = s.length(), pl = p.length();
		int[][] matrix = new int[sl+1][pl+1];

		for(int i = 0; i <= sl; i++)
			matrix[i][0] = i;

		for(int i = 1; i <= pl; i++){
			char c = p.charAt(i-1);
			if(c == '*')
				matrix[0][i] = matrix[0][i-2];
			else
				matrix[0][i] = matrix[0][i-1]+1;

		}

		for(int r = 1; r <= sl; r++)
			for(int c = 1; c <= pl; c++){
				char pc = p.charAt(c-1);
				char sc = s.charAt(r-1);

				if(pc == '.')
					matrix[r][c] = matrix[r-1][c-1];
				else if(pc == '*'){
					char pre = p.charAt(c-2);
					if(sc != pre && pre != '.') {
						matrix[r][c] = matrix[r][c-2];
					}else{
						matrix[r][c] = Math.min(matrix[r][c-2], Math.min(matrix[r][c-1], matrix[r-1][c]));
					}
				}
				else if(pc == sc)
					matrix[r][c] = matrix[r-1][c-1];
				else
					matrix[r][c] = Math.min(matrix[r-1][c-1], Math.min(matrix[r][c-1], matrix[r-1][c]))+1;
			}

		return matrix[sl][pl] == 0;
	}

}