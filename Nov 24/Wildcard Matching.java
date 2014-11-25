//Time Limit Exceeded Solution
public class Solution {
    public boolean isMatch(String s, String p) {
        
        if (s == null || p == null) {
            return false;
        }
        
        if (s.length() == 0) {
            return isValid(p);
        }
        
        if (p.length() == 0) {
            return false;
        }
        
        if (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) {
            return isMatch(s.substring(1), p.substring(1));
        } else if (p.charAt(0) == '*') {
            return isMatch(s, p.substring(1)) || isMatch(s.substring(1), p);
        }
        
        return false;
    }
    
    private boolean isValid(String p) {
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        
        return true;
    }
}