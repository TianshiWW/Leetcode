public class DataStream {
    ListNode head, tail;
    Set<Integer> visited;
    HashMap<Integer,ListNode> map;
    public DataStream(){
        // do intialization if necessary
        head = new ListNode(0);
        tail = head;
        visited = new HashSet<>();
        map = new HashMap<>();
    }
    /**
     * @param num: next number in stream
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if (visited.contains(num)) {
           return; 
        }
        if (map.containsKey(num)) {
            remove(num);
            visited.add(num);
        } else {
            ListNode node = new ListNode(num);
            map.put(num,tail);
            tail.next = node;
            tail = node;
        }
        
    }

    private void remove(int num) {
        ListNode prev = map.get(num);
        prev.next = prev.next.next;
        map.remove(num);
        if (prev.next != null) {
           map.put(prev.next.val,prev); 
        } else {
            tail = prev;
        }
        
    }
    /**
     * @return: the first unique number in stream
     */
    public int firstUnique() {
        // write your code here
        if (head.next != null) {
            return head.next.val;
        }
        return -1;
        
    }
}