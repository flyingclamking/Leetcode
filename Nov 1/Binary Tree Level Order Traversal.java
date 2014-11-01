public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }
        
        return result;
    }
}