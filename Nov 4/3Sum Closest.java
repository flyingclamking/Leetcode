public class Solution {
    public int threeSumClosest(int[] num, int target) {
        
        if (num == null || num.length < 3) {
            return -1;
        }
        
        Arrays.sort(num);
        int result = num[0] + num[1] + num[2];
        
        int prev = num[0] - 1;
        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] == prev) {
                continue;
            }
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                result = Math.abs(sum - target) < Math.abs(result - target) ? sum : result;
                if (sum > target) {
                    end--;
                    while (start < end && num[end] == num[end + 1]) {
                        end--;
                    }
                } else if (sum < target) {
                    start++;
                    while (start < end && num[start] == num[start - 1]) {
                        start++;
                    }
                } else {
                    return result;
                }
            }
        }
        
        return result;
    }
}