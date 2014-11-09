public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        
        if (num == null) {
            return null;
        }
        
        return helper(num, 0, num.length - 1);
    }
    
    private TreeNode helper(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int middle = (start + end) >> 1;
        TreeNode root = new TreeNode(num[middle]);
        root.left = helper(num, start, middle - 1);
        root.right = helper(num, middle + 1, end);
        
        return root;
    }
}