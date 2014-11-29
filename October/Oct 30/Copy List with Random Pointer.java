public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        head = doubleLinkedList(head);
        copyRandomPointer(head);
        return seperateList(head);
    }
    
    private RandomListNode doubleLinkedList(RandomListNode head) {
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode temp = new RandomListNode(curr.label);
            temp.random = curr.random;
            RandomListNode next = curr.next;
            curr.next = temp;
            temp.next = next;
            curr = curr.next.next;
        }
        return head;
    }
    
    private void copyRandomPointer(RandomListNode head) {
        RandomListNode curr = head;
        while (curr != null) {
            if (curr.next.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
    }
    
    private RandomListNode seperateList(RandomListNode head) {
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode curr = head.next;
            head.next = curr.next;
            if (curr.next != null) {
                curr.next = curr.next.next;
            }
            head = head.next;
        }
        return newHead;
    }
    
}


//HashMap Version

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if (head == null) {
            return head;
        }
        
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode curr = head;
        
        while (curr != null) {
            RandomListNode temp = new RandomListNode(curr.label);
            map.put(curr, temp);
            curr = curr.next;
        }
        
        curr = head;
        while (curr != null) {
            RandomListNode temp = map.get(curr);
            temp.next = map.get(curr.next);
            if (curr.random != null) {
                temp.random = map.get(curr.random);
            }
            curr = curr.next;
        }
        
        return map.get(head);
    }
}