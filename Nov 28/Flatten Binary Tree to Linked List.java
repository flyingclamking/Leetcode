public class Solution {
    
    private TreeNode lastNode = null;
    
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        lastNode = root;
        
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        
        flatten(root.right);
        lastNode.right = right;
        flatten(right);
    }
}