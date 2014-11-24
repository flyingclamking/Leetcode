public class Solution {
    
    private static final int max = Integer.MAX_VALUE / 10;
    
    public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int curr = 0;
        while (str.charAt(curr) == ' ') {
            curr++;
        }
        
        if (curr == str.length()) {
            return 0;
        }
        
        int sign = 1;
        if (str.charAt(curr) == '-') {
            sign = -1;
            curr++;
        } else if (str.charAt(curr) == '+') {
            curr++;
        }
        
        int result = 0;
        while (curr < str.length() && Character.isDigit(str.charAt(curr))) {
            if (result > max || result == max && (str.charAt(curr) - '0') >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(curr) - '0');
            curr++;
        }
        
        return sign * result;
    }
}