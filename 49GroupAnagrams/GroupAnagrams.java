import java.util.*;

public class GroupAnagrams{
	public static void main(String[] args){
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams(strs);
		System.out.println(res);

	}
	public static List<List<String>> groupAnagrams(String[] strs){
		HashMap<String, List<String>> map = new HashMap<>();
		for(int i = 0; i < strs.length; i++){
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String ns = new String(temp);
			if(!map.containsKey(ns))
				map.put(ns, new ArrayList<String>());
			
			map.get(ns).add(strs[i]);
		}

		List<List<String>> res = new ArrayList<>(map.values());
		return res;
	}


}