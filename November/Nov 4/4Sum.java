public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (num == null || num.length < 4) {
            return result;
        }
        
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            
            int sum = target - num[i];
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = num.length - 1;
                while (start < end) {
                    int temp = num[start] + num[j] + num[end];
                    if (temp == sum) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
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
                    } else if (temp > sum) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        
        return result;
    }
}