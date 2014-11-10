public class Solution {
    public void connect(TreeLinkNode root) {
        
        if (root == null) {
            return;
        }
        
        TreeLinkNode prev = root;
        TreeLinkNode curr = root.left;
        
        while (curr != null) {
            while (prev != null) {
                prev.left.next = prev.right;
                if (prev.next != null) {
                    prev.right.next = prev.next.left;
                }
                prev = prev.next;
            }
            prev = curr;
            curr = prev.left;
        }
        
    }
}