public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            result[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            result[i][0] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        
        return result[n - 1][m - 1];
    }
}
