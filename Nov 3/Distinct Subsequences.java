//Use rolling array to optimize space complexity
public class Solution {
    public int numDistinct(String S, String T) {
        
        if (S == null || T == null || S.length() < T.length()) {
            return 0;
        }
        
        int[][] dp = new int[2][T.length() + 1];
        
        for (int i = 0; i < 2; i++) {
            dp[i][0] = 1;
        }
        
        int c = 0;
        for (int i = 1; i < S.length() + 1; i++) {
            c = 1 - c;
            for (int j = 1; j < T.length() + 1; j++) {
                dp[c][j] = dp[1 - c][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[c][j] += dp[1 - c][j - 1];
                }
            }
        }
        
        return dp[c][T.length()];
    }
}


//DP Solution
public class Solution {
    public int numDistinct(String S, String T) {
        
        if (S == null || T == null || S.length() < T.length()) {
            return 0;
        }
        
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        
        for (int i = 0; i < S.length() + 1; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i < T.length() + 1; i++) {
            dp[0][i] = 0;
        }
        
        for (int i = 1; i < S.length() + 1; i++) {
            for (int j = 1; j < T.length() + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[S.length()][T.length()];
    }
}