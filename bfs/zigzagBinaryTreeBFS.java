/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
           return new ArrayList<>(); 
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> res = new ArrayList<>();
        int levelnum = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left); 
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                level.add(node.val);
            }
            if (levelnum % 2 == 0) {
               Collections.reverse(level); 
            }
            levelnum++;
            res.add(level);
        }
        return res;
    } 
}