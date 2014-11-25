public class Solution {
    public boolean isMatch(String s, String p) {
        
        if (s == null || p == null) {
            return false;
        }
        
        if (s.length() == 0) {
            return p.length() == 0 || isValid(p);
        }
        
        if (p.length() == 0) {
            return s.length() == 0;
        }
        
        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
        }
        
        if (p.charAt(1) == '*') {
            if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
                return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            } else {
                return isMatch(s, p.substring(2));
            }
        } else if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
            return isMatch(s.substring(1), p.substring(1));
        }
        
        return false;
    }
    
    private boolean isValid(String p) {
        int length = p.length();
        if ((length & 1) == 0) {
            for (int i = 1; i <= length - 1; i += 2) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}