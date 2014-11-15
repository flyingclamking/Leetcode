public class Solution {
    private boolean[] checker = new boolean[9];
    private static final int LENGTH = 9;
    
    public boolean isValidSudoku(char[][] board) {
        
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        return checkRow(board) && checkColumn(board) && checkCell(board);
    }
    
    private void init() {
        for (int i = 0; i < LENGTH; i++) {
            checker[i] = false;
        }
    }
    
    private boolean checkRow(char[][] board) {
        for (int i = 0; i < LENGTH; i++) {
            init();
            for (int j = 0; j < LENGTH; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (checker[(int)(board[i][j] - '0') - 1]) {
                    return false;
                } else {
                    checker[(int)(board[i][j] - '0') - 1] = true;
                }
            }
        }
        return true;
    }
    
    private boolean checkColumn(char[][] board) {
        for (int i = 0; i < LENGTH; i++) {
            init();
            for (int j = 0; j < LENGTH; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (checker[(int)(board[j][i] - '0') - 1]) {
                    return false;
                } else {
                    checker[(int)(board[j][i] - '0') - 1] = true;
                }
            }
        }
        return true;
    }
    
    private boolean checkCell(char[][] board) {
        for (int i = 0; i < LENGTH; i += 3) {
            for (int j = 0; j < LENGTH; j += 3) {
                init();
                for (int k = 0; k < LENGTH; k++) {
                    if (board[i + k / 3][j + k % 3] == '.') {
                        continue;
                    }
                    if (checker[(int)(board[i + k / 3][j + k % 3] - '0') - 1]) {
                        return false;
                    } else {
                        checker[(int)(board[i + k / 3][j + k % 3] - '0') - 1] = true;
                    }
                }
            }
        }
        return true;
    }
}