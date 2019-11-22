/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode head;
    int count;
    Random random = new Random();
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        this.count = count;
        
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int num = random.nextInt(count);
        ListNode cur = this.head;
        for(int i = 0; i < num; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */