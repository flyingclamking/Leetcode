public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if (head == null || head.next == null || m == n) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode markFirst = dummy;
        for (int i = 1; i < m; i++) {
            markFirst = markFirst.next;
        }
        
        ListNode markSecond = markFirst.next;
        ListNode prev = markSecond;
        ListNode curr = prev.next;
        ListNode next = curr.next;
        
        for (int i = 1; i <= n - m; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        markFirst.next = prev;
        markSecond.next = curr;
        
        return dummy.next;
    }
}