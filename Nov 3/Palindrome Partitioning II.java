//Time Limit Exceeded Solution
public class Solution {
    
    private int min = Integer.MAX_VALUE;
    
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        helper(s, 0, 0);
        return min;
    }
    
    private void helper(String s, int index, int number) {
        
        if (number >= min) {
            return;
        }
        
        if (index >= s.length()) {
            min = number;
            return;
        }
        
        for (int i = index + 1; i <= s.length(); i++) {
            String temp = s.substring(index, i);
            if (!isValid(temp)) {
                continue;
            }
            number++;
            helper(s, i, number);
            number--;
        }
    }
    
    private boolean isValid(String s) {
        int start = 0;
        int end = s.length() - 1;
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


//Top-Down DP Solution : Recursion + Memo
//Perform much much better but still Time Limit Exceeded
public class Solution {
    
    private Map<String, Integer> memo = new HashMap<String, Integer>();
    
    public int minCut(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        return helper(s);
    }
    
    private int helper(String s) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        int length = s.length();
        for (int i = 1; i <= length; i++) {
            String prefix = s.substring(0, i);
            if (isValid(prefix)) {
                if (i == length) {
                    memo.put(s, 1);
                } else {
                    int min = helper(s.substring(i));
                    memo.put(s, min + 1);
                }
            }
        }
        
        return memo.get(s);
    }
    
    private boolean isValid(String s) {
        int start = 0;
        int end = s.length() - 1;
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