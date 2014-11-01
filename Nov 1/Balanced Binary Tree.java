public class Solution {
    
    private static final int UNBALANCED = -1;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getHeight(root) != UNBALANCED;
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == UNBALANCED || right == UNBALANCED || Math.abs(left - right) > 1) {
            return UNBALANCED;
        }
        return Math.max(left, right) + 1;
    }
}