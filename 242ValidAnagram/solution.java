public class solution{
	public static void main(String[] args){

		String s = new String("anagram");
		String t = new String("nagaram");

		if(isAnagram(s,t)){
			System.out.println("True");
		}
		else{
			System.out.println("False");
		}

	}

	public static boolean isAnagram(String s, String t){
		int[] checklist = new int[26];

		for(int i = 0; i < s.length(); i++)
			checklist[s.charAt(i) - 'a'] ++;

		for(int i = 0; i < t.length(); i++)
			checklist[t.charAt(i) - 'a'] --;

		for(int i:checklist)
			if(i!=0)
				return false;

		return true;

	}


}
