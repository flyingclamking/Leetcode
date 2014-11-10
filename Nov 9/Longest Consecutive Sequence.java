public class Solution {
    public int longestConsecutive(int[] num) {
        
        if (num == null || num.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        
        for (Integer i : num) {
            map.put(i, 1);
        }
        
        for (Integer key : map.keySet()) {
            if (map.get(key) == 0) {
                continue;
            }
            int curr = key;
            int temp = 1;
            while (map.containsKey(--curr)) {
                map.put(curr, 0);
                temp++;
            }
            curr = key;
            while (map.containsKey(++curr)) {
                map.put(curr, 0);
                temp++;
            }
            map.put(key, 0);
            result = Math.max(result, temp);
        }
        
        return result;
    }
}