public class Solution {
    
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        
        helper(root);
        swap(first, second);
    }
    
    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        
        helper(node.left);
        if (node.val < prev.val) {
            if (first == null) {
                first = prev;
                second = node;
            } else {
                second = node;
            }
        }
        prev = node;
        helper(node.right);
    }
    
    private void swap(TreeNode n1, TreeNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

}