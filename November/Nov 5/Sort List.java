public class Solution {
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        
        head = sortList(head);
        right = sortList(right);
        head = merge(head, right);
        
        return head;
    }
    
    private ListNode findMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while (node1 != null && node2 != null) {
            if (node1.val >= node2.val) {
                curr.next = node2;
                node2 = node2.next;
            } else {
                curr.next = node1;
                node1 = node1.next;
            }
            curr = curr.next;
        }
        
        if (node1 == null) {
            curr.next = node2;
        } else {
            curr.next = node1;
        }
        
        return dummy.next;
    }
}