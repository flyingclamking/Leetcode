public class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        if (rowIndex < 0) {
            return null;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        while (rowIndex > 0) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int i = 0; i < result.size() - 1; i++) {
                temp.add(result.get(i) + result.get(i + 1));
            }
            temp.add(1);
            result = temp;
            rowIndex--;
        }
        
        return result;
    }
}