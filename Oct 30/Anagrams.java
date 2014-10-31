public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            String curr = sort(s);
            if (map.containsKey(curr)) {
                map.get(curr).add(s);
            } else {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(s);
                map.put(curr, temp);
            }
        }
        
        for (ArrayList<String> list : map.values()) {
            if (list.size() >= 2) {
                result.addAll(list);
            }
        }
        return result;
    }
    
    private String sort(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}