1019. Next Greater Node In Linked List
Medium

Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.

 

Example 1:

Input: [2,1,5]
Output: [5,5,0]
Example 2:

Input: [2,7,4,3,5]
Output: [7,0,5,5,0]
Example 3:

Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> lst = new ArrayList<>();
        while (head != null) {
            lst.add(head.val);
            head = head.next;
        }
        int size = lst.size();
        int[] res = new int[size];
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            int curr = lst.get(i);
            
            while (!stack.isEmpty() && curr > lst.get(stack.peek())) {
                int index = stack.pop();
                res[index] = curr;
            }
            stack.push(i);
        }

        return res;
    }
}