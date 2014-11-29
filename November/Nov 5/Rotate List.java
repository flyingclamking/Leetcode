public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        
        if (head == null || head.next == null || n == 0) {
            return head;
        }
        
        int length = getLength(head);
        n %= length;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        fast.next = head;
        dummy.next = slow.next;
        slow.next = null;
        
        return dummy.next;
    }
    
    private int getLength(ListNode head) {
        int count = 1;
        while (head.next != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}