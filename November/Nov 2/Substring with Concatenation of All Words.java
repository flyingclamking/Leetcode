public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        
        if (S == null || L == null || S.length() == 0 || L.length == 0) {
            return null;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> temp = new HashMap<String, Integer>();
        
        for (String s : L) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        
        int step = L[0].length();
        int size = L.length;
        
        for (int i = 0; i <= S.length() - step * size; i++) {
            temp.clear();
            int j;
            for (j = 0; j < size; j++) {
                String sub = S.substring(i + j * step, i + (j + 1) * step);
                if (!map.containsKey(sub)) {
                    break;
                } else {
                    if (temp.containsKey(sub)) {
                        temp.put(sub, temp.get(sub) + 1);
                    } else {
                        temp.put(sub, 1);
                    }
                }
                
                if (temp.get(sub) > map.get(sub)) {
                    break;
                }
            }
            if (j == size) {
                result.add(i);
            }
        }
        
        return result;
    }
}







