import java.util.*;

public class WordBreak {
    public static void main(String[] args){
        String s = "leetacode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leeta");
        wordDict.add("leet");
        wordDict.add("code");
        String res = wordBreak(s, wordDict);
        System.out.println(res);
    }
    public static String wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length()+1];
        int[] bt = new int[s.length()+1];
        res[0] = true;
        StringBuilder sr = new StringBuilder();

        for(int i = 1 ; i < s.length()+1; i++){
            for(int j = 0; j < i; j++){
                if(res[j] && wordDict.contains(s.substring(j,i))){
                    res[i] = true;
                    bt[i] = j;
                }
            }
        }
        int cur = s.length();
        while(cur != 0){
            int pre = bt[cur];
            sr.insert(0, s.substring(pre, cur));
            sr.insert(0, " ");
            cur = pre;
        }
        return sr.toString().substring(1, sr.length());
    }

}