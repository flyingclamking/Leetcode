public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (num == null || num.length < 3) {
            return result;
        }
        
        Arrays.sort(num);
        int prev = num[0] - 1;
        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] == prev) {
                continue;
            }
            
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[start]);
                    list.add(num[end]);
                    result.add(list);
                    
                    start++;
                    end--;
                    while (start < end && num[start] == num[start - 1]) {
                        start++;
                    }
                    while (start < end && num[end] == num[end + 1]) {
                        end--;
                    }
                }
            }
            prev = num[i];
        }
        
        return result;
    }
}