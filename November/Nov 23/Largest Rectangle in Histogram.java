//Time Limit Exceeded Solution
public class Solution {
    public int largestRectangleArea(int[] height) {
        
        if (height == null || height.length == 0) {
            return 0;
        }
        
        return helper(height, 0, height.length - 1);
    }
    
    private int helper(int[] height, int start, int end) {
        if (start > end) {
            return 0;
        }
        
        if (start == end) {
            return height[start];
        }
        
        if (start + 1 == end) {
            return Math.min(height[start], height[end]) * 2;
        }
        
        int index = findMin(height, start, end);
        int left = helper(height, start, index - 1);
        int right = helper(height, index + 1, end);
        int mid = height[index] * (end - start + 1);
        
        return Math.max(Math.max(left, right), mid);
    }
    
    private int findMin(int[] height, int start, int end) {
        int result = start;
        for (int i = start + 1; i <= end; i++) {
            if (height[i] < height[result]) {
                result = i;
            }
        }
        return result;
    }
}