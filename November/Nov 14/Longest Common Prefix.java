public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int curr = 0;
            while (curr < prefix.length() && curr < strs[i].length() && prefix.charAt(curr) == strs[i].charAt(curr)) {
                curr++;
            }
            if (curr == 0) {
                return "";
            }
            prefix = prefix.substring(0, curr);
        }
        
        return prefix;
    }
}