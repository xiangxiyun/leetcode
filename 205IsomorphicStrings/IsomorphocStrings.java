import java.util.*;

public class IsomorphocStrings{
	public static void main(String[] args){
		String s = "egg";
		String t = "add";

		boolean res = isIsomorphic(s, t);

		System.out.println(res);

	}

	private static boolean isIsomorphic(String s, String t){
		if(s.length() != t.length())
			return false;

		HashMap<Integer, Integer> map_s = new HashMap<>();
		HashMap<Integer, Integer> map_t = new HashMap<>();

		for(int i = 0; i < s.length(); i++){
			int temps = s.charAt(i)-'a';
			int tempt = t.charAt(i)-'a';
			if(map_s.containsKey(temps) && map_t.containsKey(tempt)){
				if(map_s.get(temps) != map_t.get(tempt))
					return false;
			}else if(!map_s.containsKey(temps) && !map_t.containsKey(tempt)){
				map_s.put(temps, map_s.size());
				map_t.put(tempt, map_t.size());
			}
			else return false;
		}
		return true;
	}
}