public class Solution {
    public LinkedList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        
        LinkedList<ArrayList<Integer>> result = new LinkedList<ArrayList<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(0, list);
        }
        
        return result;
    }
}