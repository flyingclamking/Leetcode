public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0) {
            return result;
        }
        
        Arrays.sort(S);
        helper(result, new ArrayList<Integer>(), S, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int[] S, int index) {
        if (index > S.length) {
            return;
        }
        
        result.add(new ArrayList(list));
        for (int i = index; i < S.length; i++) {
            list.add(S[i]);
            helper(result, list, S, i + 1);
            list.remove(list.size() - 1);
        }
    }
}