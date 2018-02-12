import java.util.*;

public class WordPattern{
	public static void main(String[] args){
		String pattern = "abbc";
		String str = "dog cat cat dog";

		boolean res = wordPattern(pattern, str);
		System.out.println(res);

	}

	public static boolean wordPattern(String pattern, String str){
		String[] strl = str.split(" ");
		if(pattern.length() != strl.length)
			return false;

		HashMap<Character, Integer> pmap = new HashMap<>();
		HashMap<String, Integer> smap = new HashMap<>();

		for(int i = 0; i < pattern.length(); i++){
			int pi = pmap.getOrDefault(pattern.charAt(i), pmap.size());
			int si = smap.getOrDefault(strl[i], smap.size());
			if(pi != si)
				return false;
			pmap.put(pattern.charAt(i), pi);
			smap.put(strl[i], si);
		}

		return true;

	}

}