public class Solution {
    public boolean search(int[] A, int target) {
        
        if (A == null || A.length == 0) {
            return false;
        }
        
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int middle = (start + end) >> 1;
            if (A[start] == A[middle] && A[middle] == A[end]) {
                start++;
            } else if (A[start] <= A[middle]) {
                if (target >= A[start] && target <= A[middle]) {
                    end = middle;
                } else {
                    start = middle;
                }
            } else {
                if (target >= A[middle] && target <= A[end]) {
                    start = middle;
                } else {
                    end = middle;
                }
            }
        }
        
        if (A[start] == target || A[end] == target) {
            return true;
        }
        
        return false;
    }
}