public class LRUCache {
    
    private static final int NOT_FOUND = -1;
    
    private int capacity;
    private int size;
    
    private Map<Integer, DoubleLinkedNode> cache;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<Integer, DoubleLinkedNode>();
        head = new DoubleLinkedNode(-1, -1);
        tail = new DoubleLinkedNode(-1, -1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            moveNodeToHead(cache.get(key));
            return cache.get(key).value;
        }
        return NOT_FOUND;
    }
    
    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            moveNodeToHead(cache.get(key));
            cache.get(key).value = value;
        } else {
            if (size >= capacity) {
                cache.remove(tail.prev.key);
                removeTail();
                size--;
            }
            DoubleLinkedNode node = new DoubleLinkedNode(key, value);
            cache.put(key, node);
            putNodeToHead(node);
            size++;
        }
    }
    
    private void moveNodeToHead(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        DoubleLinkedNode mark = head.next;
        
        head.next = node;
        node.prev = head;
        node.next = mark;
        mark.prev = node;
    }
    
    private void removeTail() {
        DoubleLinkedNode mark = tail.prev.prev;
        if (mark == null) {
            return;
        }
        mark.next = tail;
        tail.prev = mark;
    }
    
    private void putNodeToHead(DoubleLinkedNode node) {
        DoubleLinkedNode mark = head.next;
        head.next = node;
        node.prev = head;
        node.next = mark;
        mark.prev = node;
    }
    
    private static class DoubleLinkedNode {
        private DoubleLinkedNode prev;
        private DoubleLinkedNode next;
        private int key;
        private int value;
        
        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}