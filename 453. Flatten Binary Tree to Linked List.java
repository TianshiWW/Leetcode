453. Flatten Binary Tree to Linked List

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

Sol : 
         1(root)
       /   \
      2     3
        \     \  
          4     5

leftLast = dfs(root.left);
rightLast = dfs(root.right);
if(leftLast != null) {
    leftLast.right = root.right;
    root.right = root.left; 
    root.left = null;   
}
if (rightLast != null) {
    return rightLast;
}
if (leftLast != null) {
    return leftLast;
}
return root;



public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        
        dfs(root);
        
    }
    
    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftNode = dfs(root.left);
        TreeNode rightNode = dfs(root.right);
        
        if (leftNode != null) {
           leftNode.right = root.right;
           root.right = root.left;
           root.left = null;
        }
        
        if (rightNode != null) {
            return rightNode;
        }
        
        if(leftNode != null) {
            return leftNode;
        }
        
        return root;
        
    }
}