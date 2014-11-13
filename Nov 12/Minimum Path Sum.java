//Optimize Space From O(n^2) to O(n)
public class Solution {
    public int minPathSum(int[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int height = grid.length;
        int width = grid[0].length;
        int[] heightDp = new int[height];
        int[] widthDp = new int[width];
        
        heightDp[0] = grid[0][0];
        widthDp[0] = grid[0][0];
        
        for (int i = 1; i < width; i++) {
            widthDp[i] = widthDp[i - 1] + grid[0][i];
        }
        
        for (int i = 1; i < height; i++) {
            heightDp[i] = heightDp[i - 1] + grid[i][0];
        }
        
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (j == 1) {
                    widthDp[j] = Math.min(widthDp[j], heightDp[i]) + grid[i][j];
                } else {
                    widthDp[j] = Math.min(widthDp[j - 1], widthDp[j]) + grid[i][j];
                }
            }
        }
        
        return widthDp[width - 1];
    }
}


public class Solution {
    public int minPathSum(int[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int height = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];
        
        for (int i = 1; i < width; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        
        for (int i = 1; i < height; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                dp[i][j] += Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        
        return dp[height - 1][width - 1];
    }
}