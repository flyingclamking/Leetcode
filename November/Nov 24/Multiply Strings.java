public class Solution {
    public String multiply(String num1, String num2) {
        
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return null;
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        int len3 = len1 + len2;
        int[] result = new int[len3];
        
        int carry = 0;
        
        for (int i = len2 - 1; i >= 0; i--) {
            carry = 0;
            for (int j = len1 - 1; j >= 0; j--) {
                int product = getValue(num1.charAt(j)) * getValue(num2.charAt(i)) + carry + result[i + j + 1];
                carry = product / 10;
                result[i + j + 1] = product % 10;
            }
            result[i] = carry;
        }
        
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        while (curr < len3 - 1 && result[curr] == 0) {
            curr++;
        }
        for (; curr < len3; curr++) {
            sb.append(result[curr]);
        }
        
        return sb.toString();
    }
    
    private int getValue(char c) {
        return c - '0';
    }
}