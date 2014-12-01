public class Solution {
    public int findMin(int[] num) {
        
        if (num == null || num.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = num.length - 1;
        
        while (start + 1 < end) {
            if (num[start] < num[end]) {
                return num[start];
            }
            int middle = start + (end - start) / 2;
            if (num[middle] > num[start]) {
                start = middle;
            } else {
                end = middle;
            }
        }
        
        return Math.min(num[start], num[end]);
    }
}