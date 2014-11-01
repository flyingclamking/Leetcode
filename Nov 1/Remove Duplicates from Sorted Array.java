public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[result]) {
                A[++result] = A[i];
            }
        }
        
        return result + 1;
    }
}