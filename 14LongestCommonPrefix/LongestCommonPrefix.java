public class LongestCommonPrefix {
	public static void main(String[] args){
		String[] strs = {"", "b"};
		String res = longestCommonPrefix(strs);
		System.out.println(res);
	}

    public static String longestCommonPrefix(String[] strs) {
    	int n = strs.length;
    	if(n == 0)
    		return "";
    	int t = strs[0].length();
    	for(int i = 1; i < n; i++){
    		int c = 0;
        	for(; c < strs[i].length() && c < t; c++){
        		if(strs[0].charAt(c) != strs[i].charAt(c)){
        			t = c;
        			break;
        		}
        	}
            if(c == strs[i].length() && c < t)
                t = c;
    	}

    	String res = strs[0].substring(0,t);
    	return res;
    }
}