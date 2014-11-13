//Time Limit Exceeded Solution
public class Solution {
    
    private int min = Integer.MAX_VALUE;
    
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        helper(s, 0, 0);
        return min;
    }
    
    private void helper(String s, int index, int number) {
        
        if (number >= min) {
            return;
        }
        
        if (index >= s.length()) {
            min = number;
            return;
        }
        
        for (int i = index + 1; i <= s.length(); i++) {
            String temp = s.substring(index, i);
            if (!isValid(temp)) {
                continue;
            }
            number++;
            helper(s, i, number);
            number--;
        }
    }
    
    private boolean isValid(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}