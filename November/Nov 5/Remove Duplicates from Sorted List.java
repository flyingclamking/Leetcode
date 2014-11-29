public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = deleteDuplicates(head.next);
        if (head.val == curr.val) {
            head.next = curr.next;
        } else {
            head.next = curr;
        }
        
        return head;
    }
}


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(head.val - 1);
        ListNode result = dummy;
        int prev = dummy.val;
        
        while (head != null) {
            if (head.val != prev) {
                dummy.next = head;
                dummy = head;
                prev = head.val;
            }
            head = head.next;
        }
        dummy.next = null;
        
        return result.next;
    }
}


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}