public class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode next = head.next;
            head.next = node.next;
            node.next = head;
            head = next;
        }
        
        return dummy.next;
    }
}