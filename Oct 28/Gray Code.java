public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        if (n <= 0) {
            return result;
        }
        
        result.add(1);
        for (int i =  2; i <= n; i++) {
            int step = 1 << (i - 1);
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(result.get(j) + step);
            }
        }
        
        return result;
    }
}