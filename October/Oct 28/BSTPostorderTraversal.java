public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode prev = null;
        TreeNode curr = root;
        stack.push(root);
        
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    result.add(stack.pop().val);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    result.add(stack.pop().val);
                }
            } else {
                result.add(stack.pop().val);
            }
            prev = curr;
        }
        
        return result;
    }
}