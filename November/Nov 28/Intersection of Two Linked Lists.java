public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == null || headB == null) {
            return null;
        }
        
        int length1 = 1;
        int length2 = 1;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        
        while (temp1.next != null || temp2.next != null) {
            if (temp1.next != null) {
                temp1 = temp1.next;
                length1++;
            }
            if (temp2.next != null) {
                temp2 = temp2.next;
                length2++;
            }
        }
        
        if (temp1 != temp2) {
            return null;
        }
        
        temp1 = headA;
        temp2 = headB;
        
        if (length2 > length1) {
            while (length2 - length1 > 0) {
                temp2 = temp2.next;
                length2--;
            }
        } else {
            while (length1 - length2 > 0) {
                temp1 = temp1.next;
                length1--;
            }
        }
        
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return temp1;
    }
}