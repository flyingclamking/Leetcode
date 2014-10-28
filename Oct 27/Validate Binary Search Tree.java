public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean helper(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}
