public class Solution {
    private int result = 0;
    
    public int totalNQueens(int n) {
        List<Integer> board = new ArrayList<Integer>();
        if (n <= 0) {
            return 0;
        }
        
        helper(board, n);
        return result;
    }
    
    private void helper(List<Integer> board, int n) {
        if (board.size() == n) {
            result++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(board, i)) {
                board.add(i);
                helper(board, n);
                board.remove(board.size() - 1);
            }
        }
    }
    
    private boolean isValid(List<Integer> board, int i) {
        for (int j = 0; j < board.size(); j++) {
            if (board.get(j) == i) {
                return false;
            }
            if (Math.abs(j - board.size()) == Math.abs(board.get(j) - i)) {
                return false;
            }
        }
        
        return true;
    }
}