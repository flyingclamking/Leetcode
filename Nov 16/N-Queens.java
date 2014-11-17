public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        
        if (n <= 0) {
            return result;
        }
        
        List<Integer> board = new ArrayList<Integer>();
        helper(result, board, n);
        return result;
    }
    
    private void helper(List<String[]> result, List<Integer> board, int n) {
        if (board.size() == n) {
            printResult(result, board);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(board, i)) {
                board.add(i);
                helper(result, board, n);
                board.remove(board.size() - 1);
            }
        }
    }
    
    private void printResult(List<String[]> result, List<Integer> board) {
        String[] temp = new String[board.size()];
        int curr = 0;
        
        for (Integer i : board) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append(".");
            }
            sb.append("Q");
            for (int j = i + 1; j < board.size(); j++) {
                sb.append(".");
            }
            temp[curr++] = sb.toString();
        }
        result.add(temp);
    }
    
    private boolean isValid(List<Integer> board, int i) {
        for (int j = 0; j < board.size(); j++) {
            if (board.get(j) == i) {
                return false;
            }
            if (board.size() - j == Math.abs(i - board.get(j))) {
                return false;
            }
        }
        return true;
    }
}