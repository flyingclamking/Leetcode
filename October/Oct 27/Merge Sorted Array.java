public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null || B.length == 0) {
            return;
        }
        
        int index1 = m - 1;
        int index2 = n - 1;
        int length = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (A[index1] > B[index2]) {
                A[length--] = A[index1--];
            } else {
                A[length--] = B[index2--];
            }
        }
        
        while (index2 >= 0) {
            A[length--] = B[index2--];
        }
    }
}
