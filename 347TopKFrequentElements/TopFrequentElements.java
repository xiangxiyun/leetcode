import java.util.*;

public class TopFrequentElements{
	public static void main(String[] args){
		int[] nums = {5,2,5,3,5,3,1,1,3};
		List<Integer> res = topKFrequent(nums, 2);

		System.out.println(res);

	}

	private static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < nums.length; i++){
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		//TODO:using priority queue to do it
		PriorityQueue<Pair> pq = new PriorityQueue<>(new checker());

		for(int key: map.keySet()){
			int freq = map.get(key);
			pq.add(new Pair(key, freq));
		}

		List<Integer> res = new ArrayList<>();

		while(res.size() < k){
			res.add(pq.poll().key);
		}
		return res;
	}
}

class checker implements Comparator<Pair>{
	public int compare(Pair a, Pair b){
		if(a.freq < b.freq)
			return 1;
		else if(a.freq > b.freq)
			return -1;
		else
			return 0;
	}
}
class Pair{
	int key;
	int freq;
	public Pair(int k, int v){key = k; freq = v;}
}