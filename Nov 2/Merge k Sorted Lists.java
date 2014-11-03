public class Solution {
    
    public ListNode mergeKLists(List<ListNode> lists) {
        
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        
        while (heap.size() != 0) {
            dummy.next = heap.poll();
            dummy = dummy.next;
            if (dummy.next != null) {
                heap.add(dummy.next);
            }
        }
        
        return head.next;
    }
}