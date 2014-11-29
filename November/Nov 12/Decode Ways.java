//Time Limit Exceeded Solution : Simple Backtracking Algorithm
public class Solution {
    
    private int result = 0;
    
    public int numDecodings(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        helper(s);
        return result;
    }
    
    private void helper(String s) {
        
        if (s.length() == 0) {
            result++;
            return;
        }
        
        if (s.charAt(0) == '0') {
            return;
        }
        
        if (s.length() == 1) {
            result++;
            return;
        }
        
        helper(s.substring(1));
        if (isValid(s.substring(0, 2))) {
            helper(s.substring(2));
        }
    }
    
    private boolean isValid(String s) {
        int result = Integer.parseInt(s);
        if (result >= 1 && result <= 26) {
            return true;
        }
        
        return false;
    }
}


//Bottom-up DP
public class Solution {
    public int numDecodings(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            
            if (isValid(s.substring(i - 2, i))) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
    
    private boolean isValid(String s) {
        int value = Integer.valueOf(s);
        if (value >= 10 && value <= 26) {
            return true;
        }
        return false;
    }
}
