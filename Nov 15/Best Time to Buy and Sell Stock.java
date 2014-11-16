public class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int result = Integer.MIN_VALUE;
        int minProfit = prices[0];
        
        for (int i = 0; i < prices.length; i++) {
            minProfit = Math.min(minProfit, prices[i]);
            result = Math.max(result, prices[i] - minProfit);
        }
        
        return result;
    }
}