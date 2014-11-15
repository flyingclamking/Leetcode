public class Solution {
    public void setZeroes(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        boolean row = false;
        boolean column = false;
        int width = matrix[0].length;
        int height = matrix.length;
        
        for (int i = 0; i < width; i++) {
            if (matrix[0][i] == 0) {
                row = true;
                break;
            }
        }
        
        for (int i = 0; i < height; i++) {
            if (matrix[i][0] == 0) {
                column = true;
                break;
            }
        }
        
        for (int i = 1; i < width; i++) {
            for (int j = 1; j < height; j++) {
                if (matrix[j][i] == 0) {
                    matrix[0][i] = 0;
                    matrix[j][0] = 0;
                }
            }
        }
        
        for (int i = 1; i < width; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < height; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        for (int j = 1; j < height; j++) {
            if (matrix[j][0] == 0) {
                for (int i = 0; i < width; i++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        if (row) {
            for (int i = 0; i < width; i++) {
                matrix[0][i] = 0;
            }
        }
        
        if (column) {
            for (int i = 0; i < height; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}