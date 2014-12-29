public class Solution {
    public String convertToTitle(int n) {
        
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        
        StringBuilder result = new StringBuilder();
        
        while (n != 0) {
            int curr = n % 26;
            if (curr == 0) {
                curr = 26;
                n--;
            }
            n /= 26;
            result.append((char)('A' + curr - 1));
        }
        
        return result.reverse().toString();
    }
}