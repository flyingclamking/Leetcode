/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        helper(result, new ArrayList<Integer>(), root, sum);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, TreeNode node, int sum) {
        sum -= node.val;
        list.add(node.val);
        
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        if (node.left != null) {
            helper(result, list, node.left, sum);
            list.remove(list.size() - 1);
        }
        
        if (node.right != null) {
            helper(result, list, node.right, sum);
            list.remove(list.size() - 1);
        }
        
    }
}