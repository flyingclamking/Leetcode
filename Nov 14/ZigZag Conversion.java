public class Solution {
    public String convert(String s, int nRows) {
        
        if (s == null || s.length() <= nRows || nRows == 1) {
            return s;
        }
        
        int step = 2 * (nRows - 1);
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i += step) {
            result.append(s.charAt(i));
        }
        
        for (int i = 1; i < nRows - 1; i++) {
            int curr = i;
            int interval = step - 2 * i;
            while (curr < s.length()) {
                result.append(s.charAt(curr));
                curr += interval;
                interval = step - interval;
            }
        }
        
        for (int i = nRows - 1; i < s.length(); i += step) {
            result.append(s.charAt(i));
        }
        
        return result.toString();
    }
}