public class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        
        LinkedList<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root.left);
        deque.add(root.right);
        
        while (!deque.isEmpty()) {
            TreeNode first = deque.pollFirst();
            TreeNode last = deque.pollLast();
            
            if (first != null && last != null) {
                if (first.val == last.val) {
                    deque.addFirst(first.right);
                    deque.addFirst(first.left);
                    deque.addLast(last.left);
                    deque.addLast(last.right);
                } else {
                    return false;
                }
            } else if (first == null && last == null) {
                continue;
            } else {
                return false;
            }
        }
        
        return true;
    }
}
