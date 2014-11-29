public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        if (s == null || s.length() == 0) {
            return result;
        }
        
        helper(result, new ArrayList<String>(), s, 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<String>> result, ArrayList<String> list, String s, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }
        
        for (int i = index + 1; i <= s.length(); i++) {
            String temp = s.substring(index, i);
            if (isValid(temp)) {
                list.add(temp);
                helper(result, list, s, i);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        int end = s.length() - 1;
        int start = 0;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}