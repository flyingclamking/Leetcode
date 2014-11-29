public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (numRows <= 0) {
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        result.add(new ArrayList(list));
        
        for (int i = 2; i <= numRows; i++) {
            list = result.get(i - 2);
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 0; j < list.size() - 1; j++) {
                temp.add(list.get(j) + list.get(j + 1));
            }
            temp.add(1);
            result.add(temp);
        }
        
        return result;
    }
}