public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return null;
        }
        
        List<String> result = new ArrayList<String>();
        helper(result, n, n, "");
        
        return result;
    }
    
    private void helper(List<String> result, int left, int right, String s) {
        if (right < left || left < 0) {
            return;
        }
        
        if (right == 0) {
            result.add(s);
        }
        
        helper(result, left - 1, right, s + "(");
        helper(result, left, right - 1, s + ")");
    }
}



//This solution will cause Time Limit Exceeded.

public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            return null;
        }
        
        List<String> result = new ArrayList<String>();
        helper(result, new StringBuilder(), n, n);
        return result;
    }
    
    private void helper(List<String> result, StringBuilder sb, int left, int right) {
        if (right < left || left < 0) {
            return;
        }
        if (right == 0) {
            result.add(sb.toString());
        }
        
        helper(result, sb.append("("), left - 1, right);
        helper(result, sb.append(")"), left, right - 1);
    }
}