import java.util.*;

public class Stickers{
	public static void main(String[] args){
		String[] stickers = {"a","enemy","material","whose","twenty","describe","magnet","put","hundred","discuss"};
		String target = "separatewhich";

		int res = minStickers(stickers, target);

		System.out.println(res);


	}
	private static int minStickers(String[] stickers, String target){
		//check whether all the characters in target can be found in stickers
		int[] cbag = new int[26];

		for(int i = 0; i < stickers.length; i++){
			for(int j = 0; j < stickers[i].length(); j++){
				cbag[stickers[i].charAt(j) - 'a'] = 1;
			}
		}

		for(int i = 0; i < target.length(); i++)
			if(cbag[target.charAt(i)-'a'] == 0)
				return -1;

		//backtracking
		HashMap<Character, Integer> tbag = new HashMap<>();
		for(int i = 0; i < target.length(); i++){
			char c = target.charAt(i);
			if(tbag.containsKey(c))
				tbag.put(c, tbag.get(c) + 1);
			else
				tbag.put(c, 1);
		}

		return backtracking(stickers, tbag, 0);


		
	}
	private static int backtracking(String[] stickers, HashMap<Character, Integer> tbag, int num){
		if(tbag.size()==0)
			return num;

		int min = Integer.MAX_VALUE;
		for(int i = 0; i < stickers.length; i++){
			
			ArrayList<Character> temp = new ArrayList<>();
			//update tbag
			for(int j = 0; j < stickers[i].length(); j++){
				char c = stickers[i].charAt(j);
				if(tbag.containsKey(c)){
					temp.add(c);
					if(tbag.get(c) == 1) tbag.remove(c);
					else tbag.put(c, tbag.get(c) - 1);
				}
			}

			if(temp.size() == 0)
				continue;
			
			num++;
			min = Math.min(backtracking(stickers, tbag, num), min);

			//recover tbag
			num--;
			for(int j = 0; j < temp.size(); j++){
				char c = temp.get(j);
				if(tbag.containsKey(c))
					tbag.put(c, tbag.get(c) + 1);
				else
					tbag.put(c, 1);
			}
						


		}
		return min;

	}
}