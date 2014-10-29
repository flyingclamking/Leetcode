public class Solution {
    public double pow(double x, int n) {
        boolean sign = false;
        if (n < 0) {
            sign = true;
            n = -n;
        }
        
        return sign ? 1.0 / helper(x, n) : helper(x, n);
    }
    
    private double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        
        double result = helper(x, n / 2);
        return (n & 1) == 0 ? result * result : result * result * x;
    }
}