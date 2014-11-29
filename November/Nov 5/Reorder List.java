public class Solution {
    public void reorderList(ListNode head) {
        
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode secondList = seperateList(head);
        secondList = reverseList(secondList);
        mergetList(head, secondList);
    }
    
    private ListNode seperateList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        
        while (head != null && head.next != null) {
            dummy = dummy.next;
            head = head.next.next;
        }
        
        ListNode result = dummy.next;

        //IMPORTANT!!!
        dummy.next = null;
        return result;
    }
    
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode temp = head.next;
        ListNode result = reverseList(temp);
        temp.next = head;
        head.next = null;
        
        return result;
    }
    
    private void mergetList(ListNode l1, ListNode l2) {
        
        ListNode next1, next2;
        while (l1 != null && l2 != null) {
            next1 = l1.next;
            next2 = l2.next;
            
            l1.next = l2;
            l2.next = next1;
            l1 = next1;
            l2 = next2;
        }
    }
}