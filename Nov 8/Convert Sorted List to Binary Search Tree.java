public class Solution {
    
    private ListNode curr;
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        curr = head;
        int size = getLength(head);
        return helper(size);
    }
    
    private int getLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    
    private TreeNode helper(int size) {
        if (size <= 0) {
            return null;
        }
        
        TreeNode left = helper(size / 2);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode right = helper(size - 1 - size / 2);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    
}