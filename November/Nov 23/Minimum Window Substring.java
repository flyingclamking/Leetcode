//Time Limit Exceeded Solution
public class Solution {
    public String minWindow(String S, String T) {
        
        if (S == null || T == null || S.length() < T.length()) {
            return "";
        }
        
        int length = S.length();
        int step = T.length();
        
        for (int i = step; i <= length; i++) {
            for (int j = 0; j < length - i + 1; j++) {
                String sub = S.substring(j, j + step);
                if (containsAll(sub, T)) {
                    return sub;
                }
            }
        }
        
        return "";
    }
    
    private boolean containsAll(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0) {
                return false;
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        
        return true;
    }
}