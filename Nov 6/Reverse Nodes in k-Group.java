public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head == null || head.next == null || k == 0 || k == 1) {
            return head;
        }
        
        int length = getLength(head);
        int step = length / k;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode markFirst = dummy;
        ListNode prev, curr, next, markSecond;
        
        for (int i = 1; i <= step; i++) {
            prev = markFirst.next;
            curr = prev.next;
            next = curr.next;
            markSecond = prev;
            for (int j = 1; j < k; j++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            markSecond.next = curr;
            markFirst.next = prev;
            markFirst = markSecond;
        }
        
        return dummy.next;
    }
    
    private int getLength(ListNode head) {
        int result = 0;
        while (head != null) {
            head = head.next;
            result++;
        }
        return result;
    }
}