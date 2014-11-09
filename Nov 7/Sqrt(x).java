public class Solution {
    public int sqrt(int x) {
        
        if (x < 0) {
            throw new ArithmeticException();
        }
        
        long start = 0;
        long end = x;
        
        while (start <= end) {
            long mid = (start + end) >> 1;
            if (mid * mid > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return (int) end;
    }
}