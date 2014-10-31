public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (num == null || num.length == 0) {
            return result;
        }
        
        Arrays.sort(num);
        boolean[] used = new boolean[num.length];
        helper(result, list, num, used);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, boolean[] used) {
        if (list.size() == num.length) {
            result.add(new ArrayList(list));
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (used[i] || (i > 0 && num[i - 1] == num[i] && !used[i - 1])) {
                continue;
            }
            list.add(num[i]);
            used[i] = true;
            helper(result, list, num, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}