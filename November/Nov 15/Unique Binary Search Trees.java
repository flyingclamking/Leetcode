//Top-Down DP
public class Solution {
    
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        
        map.put(0, 1);
        return helper(n);
    }
    
    private int helper(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = result + helper(n - i) * helper(i - 1);
        }
        
        map.put(n, result);
        return result;
    }
}

//Bottom-Up DP
public class Solution {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        
        return dp[n];
    }
}