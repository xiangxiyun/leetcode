import java.util.*;

public class WordBreak {
    public static void main(String[] args){
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("a");
        wordDict.add("code");
        boolean res = wordBreak(s, wordDict);
        System.out.println(res);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] d = new boolean[s.length()+1];
        d[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(String w:wordDict){
                if(w.length() <= i){
                    if(s.substring(i-w.length(), i).equals(w) && d[i-w.length()] == true){
                        d[i] = true;
                        break;
                    }
                }
            }
        }
        // for(int i = 0; i <= s.length(); i++){
        //     System.out.println(d[i]);
        // }
        return d[s.length()];
              
    }

}