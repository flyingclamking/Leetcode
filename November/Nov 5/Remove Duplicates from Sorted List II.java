public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        dummy.next = head;
        
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int val = curr.next.val;
                while (curr.next != null && curr.next.val == val) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}