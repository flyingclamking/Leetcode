public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        
        int result = 0;
        int store = 0;
        int totalCost = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalCost += (gas[i] - cost[i]);
            store += (gas[i] - cost[i]);
            if (store < 0) {
                result = i + 1;
                store = 0;
            }
        }
        
        if (totalCost < 0) {
            return -1;
        }
        
        return result;
    }
}