public class Solution {
    public ListNode partition(ListNode head, int x) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode smallDummy = small;
        ListNode bigDummy = big;
        
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = head;
            } else {
                big.next = head;
                big = head;
            }
            head = head.next;
        }
        
        /*IMPORTATNT : Prevent cycle*/
        big.next = null;
        small.next = bigDummy.next;
        return smallDummy.next;
    }
}