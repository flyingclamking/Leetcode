public class Solution {
    public int jump(int[] A) {
        
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int[] result = new int[A.length];
        result[0] = 0;
        
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] + j >= i) {
                    result[i] = result[j] + 1;
                    break;
                }
            }
        }
        
        return result[A.length - 1];
    }
}