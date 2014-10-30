public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        
        int size = triangle.size();
        int[][] result = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            result[size - 1][i] = triangle.get(size - 1).get(i);
        }
        
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                result[i][j] = triangle.get(i).get(j) + Math.min(result[i + 1][j], result[i + 1][j + 1]);
            }
        }
        
        return result[0][0];
    }
}