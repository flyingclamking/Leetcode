public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + carry;
            curr.next = new ListNode(temp % 10);
            carry = temp / 10;
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }
        
        while (l2 != null) {
            int temp = l2.val + carry;
            curr.next = new ListNode(temp % 10);
            carry = temp / 10;
            l2 = l2.next;
            curr = curr.next;
        }
        
        while (l1 != null) {
            int temp = l1.val + carry;
            curr.next = new ListNode(temp % 10);
            carry = temp / 10;
            l1 = l1.next;
            curr = curr.next;
        }
        
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}