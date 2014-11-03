//Time Limit Exceeded Solution

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        
        List<String> result = new ArrayList<String>();
        
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return result;
        }
        
        helper(s, dict, result, 0, new StringBuilder());
        return result;
    }
    
    private void helper(String s, Set<String> dict, List<String> result, int index, StringBuilder sb) {
        if (index == s.length()) {
            result.add(sb.deleteCharAt(sb.length() - 1).toString());
            return;
        }
        
        StringBuilder temp = new StringBuilder(sb);
        for (int i = index; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (!dict.contains(sub)) {
                    continue;
                } else {
                    sb.append(sub + " ");
                    helper(s, dict, result, j, sb);
                    sb = temp;
                }
            }
        }
    }
    
}