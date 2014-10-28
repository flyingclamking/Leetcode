public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                result[0][i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                result[i][0] = 1;
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        
        return result[n - 1][m - 1];
    }
}
