public class Solution {
    public int removeDuplicates(int[] A) {
        
        if (A == null) {
            return 0;
        }
        
        if (A.length <= 2) {
            return A.length;
        }
        
        int prev = 1;
        int curr = 2;
        while (curr < A.length) {
            if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
                curr++;
            } else {
                A[++prev] = A[curr++];
            }
        }
        
        return ++prev;
    }
}


public class Solution {
    public int removeDuplicates(int[] A) {
        
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int result = 0;
        boolean flag = false;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[result]) {
                flag = false;
                A[++result] = A[i];
            } else if (i != 0 && !flag) {
                A[++result] = A[i];
                flag = true;
            }
        }
        
        return result + 1;
    }
}