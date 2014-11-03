//Time Limit Exceeded
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        if (s == null || dict == null || s.length() == 0 || dict.size() == 0) {
            return false;
        }
        
        return helper(s, dict);
    }
    
    private boolean helper(String s, Set<String> dict) {
        
        if (s.length() == 0) {
            return true;
        }
        
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (dict.contains(s.substring(0, i)) && helper(s.substring(i), dict)) {
                return true;
            }
        }
        
        return false;
    }
}


//DP Solution
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        if (s == null || dict == null || s.length() == 0 || dict.size() == 0) {
            return false;
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
 
        for(int i = 0; i < s.length(); i++) {
            if (dp[i]) {
                for(String curr : dict) {
                    int len = curr.length();
                    int end = i + len;
                    if(end <= s.length() && !dp[end] && s.substring(i, end).equals(curr)) {
                        dp[end] = true;
                    }
                }
            }
        }
        
        return dp[s.length()];
    }
}