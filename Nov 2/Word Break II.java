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


//Top-Down DP : Recursion + Memo
public class Solution {
    
    private Map<String, ArrayList<String>> memo = new HashMap<String, ArrayList<String>>();
    
    public List<String> wordBreak(String s, Set<String> dict) {
        
        if (s == null || dict == null) {
            return null;
        }
        
        return helper(s, dict);
    }
    
    private ArrayList<String> helper(String s, Set<String> dict) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        ArrayList<String> result = new ArrayList<String>();
        int length = s.length();
        if (length <= 0) {
            return result;
        }
        
        for (int i = 1; i <= length; i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                if (i == length) {
                    result.add(prefix);
                } else {
                    ArrayList<String> temp = helper(s.substring(i), dict);
                    for (String curr : temp) {
                        result.add(prefix + " " + curr);
                    }
                }
            }
        }
        
        memo.put(s, result);
        return result;
    }
}