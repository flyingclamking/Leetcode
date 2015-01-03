public class Solution {
    public int trailingZeroes(int n) {
        n = (n >> 31) == 0 ? n : (~n + 1);
        
        int result = 0;
        while (n != 0) {
            n /= 5;
            result += n;
        }
        
        return result;
    }
}