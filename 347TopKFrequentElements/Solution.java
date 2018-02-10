import java.util.*;

public class Solution{
	public static void main(String[] args){
		int [] nums = new int[]{1,1,1,2,2,3};
		int k = 2;

		List<Integer> res = topKFrequent(nums, k);
		System.out.println(res);

	}
	public static List<Integer> topKFrequent(int[] nums, int k){
		//how to instantiate the array of ArrayList:
		ArrayList<Integer>[] buckets = new ArrayList[nums.length+1];

        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int n:nums){
            freq.put(n, freq.getOrDefault(n,0) + 1);
        }
        
        for(int key:freq.keySet()){
            int frequency = freq.get(key);
            
            if(buckets[frequency] == null)
                buckets[frequency] = new ArrayList<>();
            
            buckets[frequency].add(key);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = buckets.length-1; i > 0 && res.size() < k; i--){
            if(buckets[i] != null)
                res.addAll(buckets[i]);
        }
        return res;

	}
}