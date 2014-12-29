public class Solution {
    public int titleToNumber(String s) {
        
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result *= 26;
            result += s.charAt(i) - 'A' + 1;
        }
        
        return result;
    }
}