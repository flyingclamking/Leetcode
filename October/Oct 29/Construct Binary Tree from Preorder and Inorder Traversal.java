public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (inEnd < inStart) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = findIndex(inorder, inStart, inEnd, preorder[preStart]);
        
        //--IMPORTANT--//
        root.left = helper(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index - 1);
        root.right = helper(preorder, index - inEnd + preEnd + 1, preEnd, inorder, index + 1, inEnd);
        
        return root;
    }
    
    private int findIndex(int[] array, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
