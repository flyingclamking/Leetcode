//Constant Space Solution




//BFS Solution
public class Solution {
    public void connect(TreeLinkNode root) {
        
        if (root == null) {
            return;
        }
        
        Deque<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode curr = queue.poll();
                if (i != size - 1) {
                    curr.next = queue.peek();
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        
    }
}