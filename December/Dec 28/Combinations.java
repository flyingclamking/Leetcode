public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (k > n || n <= 0 || k <= 0) {
            return result;
        }
        
        helper(result, new ArrayList<Integer>(), n, k, 1);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        if (index > n) {
            return;
        }
        
        for (int i = index; i <= n; i++) {
            list.add(i);
            helper(result, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}