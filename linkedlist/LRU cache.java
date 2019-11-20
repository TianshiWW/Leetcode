
class DLinkedNode{
    int key;
    int val;
    DLinkedNode prev;
    DLinkedNode next;
}

public class LRUCache {

    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
    * add node to head
    */
    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        
    }
    /**
    * remove the node
    */
    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    /**
    * remove last node
    */
    private DLinkedNode popTail() {
        DLinkedNode lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }
    

    /**
    * get value of the node by key
    */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        removeNode(node);
        addToHead(node);
        return node.val;
    }
    /**
    * put in new value
    */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.val = value;
            cache.put(key,newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.val = value;
            removeNode(node);
            addToHead(node);
        }
    }
}