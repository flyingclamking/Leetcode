public class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<String>();
        if (digits == null) {
            return result;
        }
        
        Map<Character, char[]> map = initMap();
        StringBuilder sb = new StringBuilder();
        helper(result, map, digits, sb, 0);
        return result;
    }
    
    private void helper(List<String> result, Map<Character, char[]> map, String s, StringBuilder sb, int index) {
        if (index == s.length()) {
            result.add(sb.toString());
            return;
        }
        
        for (char c : map.get(s.charAt(index))) {
            sb.append(c);
            helper(result, map, s, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    
    private Map<Character, char[]> initMap() {
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
        
        return map;
    }
}
