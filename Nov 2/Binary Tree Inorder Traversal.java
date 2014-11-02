public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode p = root;
        
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            } else {
                TreeNode t = stack.pop();
                result.add(t.val);
                p = t.right;
            }
        }
        
        return result;
        
    }
}


//Morris Traversal
//O(1) Space Complexity

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }
        
        TreeNode curr = root;
        TreeNode rightMost = null;
        
        while (curr != null) {
            if (curr.left != null) {
                rightMost = curr.left;
                while (rightMost.right != null && rightMost.right != curr) {
                    rightMost = rightMost.right;
                }
                if (rightMost.right == null) {
                    rightMost.right = curr;
                    curr = curr.left;
                } else {
                    rightMost.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            } else {
                result.add(curr.val);
                curr = curr.right;
            }
        }
        
        return result;
    }
}