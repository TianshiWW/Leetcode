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
    List<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return res;
        }   
        
        res.add(root.val);
        if (root.left == null && root.right == null) {
            return res;
        }
        
        dfsLeft(root.left);
        dfsLeaf(root);
        dfsRight(root.right);
        
        return res;
    }
    
    private void dfsLeft(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
           return; 
        }
        res.add(root.val);
        if (root.left != null) {
            dfsLeft(root.left);
        } else {
            dfsLeft(root.right);
        }
        return;
    }
    
    private void dfsLeaf(TreeNode root) {
        if (root == null) {
           return; 
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        dfsLeaf(root.left);
        dfsLeaf(root.right);
        return;  
    }
    
    private void dfsRight(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right != null) {
            dfsRight(root.right);
        } else {
            dfsRight(root.left);
        }
        res.add(root.val);
        return;
    }
}