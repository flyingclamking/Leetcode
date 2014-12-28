public class Solution {
    public int majorityElement(int[] num) {
        
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int result = num[0];
        int time = 1;
        
        for (int i = 1; i < num.length; i++) {
            if (num[i] == result) {
                time++;
            } else {
                if (--time == 0) {
                    result = num[i];
                    time = 1;
                }
            }
        }
        
        return result;
    }
}