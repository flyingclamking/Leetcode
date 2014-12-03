public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        
        int start = 0;
        int curr = 0;
        int end = A.length - 1;
        
        while (curr <= end) {
            if (A[curr] == 0) {
                swap(A, curr, start);
                start++;
                curr++;
            } else if (A[curr] == 1) {
                curr++;
            } else {
                swap(A, curr, end);
                end--;
            }
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}