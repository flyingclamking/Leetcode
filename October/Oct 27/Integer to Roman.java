public class Solution {
    public String intToRoman(int num) {
        
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	StringBuilder result = new StringBuilder();
	int index = 0;
        
        while (num > 0) {
            int time = num / nums[index];
            num -= nums[index] * time;
            while (time > 0) {
                result.append(symbols[index]);
                time--;
            }
            index++;
        }
        
        return result.toString();
    }
}
