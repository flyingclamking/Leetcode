public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        
        for (int i = 0; i < numbers.length - 1; i++) {
            if (map.containsKey(target - numbers[i]) && map.get(target - numbers[i]) != i) {
                result[0] = i + 1;
                result[1] = map.get(target - numbers[i]) + 1;
                break;
            }
        }
        
        return result;
    }
}