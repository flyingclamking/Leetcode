public class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr, next;
        
        while (prev.next != null && prev.next.next != null) {
            curr = prev.next;
            next = curr.next;
            ListNode mark = next.next;
            
            next.next = curr;
            curr.next = mark;
            prev.next = next;
            prev = curr;
        }
        
        return dummy.next;
    }
}