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
            if (num[start] == num[end]) {
                start++;
                continue;
            }
            int middle = start + (end - start) / 2;
            if (num[start] <= num[middle]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        
        return Math.min(num[start], num[end]);
    }
}