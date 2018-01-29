import java.util.*;

public class LetterCombinations{
	private static final String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public static void main(String[] args){
		String digits = "";
		List<String> res = letterCombinations(digits);
		System.out.println(res);

	}

	private static List<String> letterCombinations(String digits){
		List<String> res = new ArrayList<>();
		
		if(digits.length == 0)
			return res;

		backtracking(res, new StringBuilder(), digits, 0);
		return res;
	}

	private static void backtracking(List<String>res, StringBuilder s, String digits, int k){
		if(k == digits.length())
			res.add(s.toString());
		else{
			int d = digits.charAt(k) - '0';
			for(int i = 0; i < keys[d].length(); i++){
				char c = keys[d].charAt(i);
				s.append(c);
				backtracking(res, s, digits, k+1);
				s.deleteCharAt(s.length()-1);
			}
		}
	}


}