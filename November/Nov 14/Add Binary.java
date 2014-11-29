public class Solution {
    public String addBinary(String a, String b) {
        
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return "";
        }
        
        int curr = 1;
        int lenA = a.length();
        int lenB = b.length();
        int carry = 0;
        StringBuilder result = new StringBuilder();
        
        while (lenA - curr >= 0 && lenB - curr >= 0) {
            int value = (int)(a.charAt(lenA - curr) - '0') + (int)(b.charAt(lenB - curr) - '0') + carry;
            result.append(value % 2 + "");
            carry = value >> 1;
            curr++;
        }
        
        if (curr > lenA) {
            while (lenB - curr >= 0) {
                int value = (int)(b.charAt(lenB - curr) - '0') + carry;
                result.append(value % 2 + "");
                carry = value >> 1;
                curr++;
            }
        }
        
        if (curr > lenB) {
            while (lenA - curr >= 0) {
                int value = (int)(a.charAt(lenA - curr) - '0') + carry;
                result.append(value % 2 + "");
                carry = value >> 1;
                curr++;
            }
        }
        
        if (carry != 0) {
            result.append("1");
        }
        
        return result.reverse().toString();
    }
}