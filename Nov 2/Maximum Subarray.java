public class Solution {
    public int maxSubArray(int[] A) {
        
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int[] dp = new int[A.length];
        int result = A[0];
        dp[0] = A[0];
        
        for (int i = 1; i < A.length; i++) {
            dp[i] = dp[i - 1] >= 0 ? dp[i - 1] + A[i] : A[i];
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}


//Constant Space
public class Solution {
    public int maxSubArray(int[] A) {
        
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int max = A[0];
        int prev = A[0];
        for (int i = 1; i < A.length; i++) {
            prev = (prev >= 0) ? prev + A[i] : A[i];
            max = max > prev ? max : prev;
        }
        
        return max;
    }
}