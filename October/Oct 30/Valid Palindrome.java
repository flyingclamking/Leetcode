public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < s.length() && !isValid(s.charAt(start))) {
                start++;
            }
            
            if (start == s.length()) {
                break;
            }
            
            while (end >= 0 && !isValid(s.charAt(end))) {
                end--;
            }
            
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        
        return start >= end;
    }
    
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}