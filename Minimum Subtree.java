Minimum Subtree
596
中文English
Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

Example
Example 1:

Input:
{1,-5,2,1,2,-4,-5}
Output:1
Explanation:
The tree is look like this:
     1
   /   \
 -5     2
 / \   /  \
1   2 -4  -5 
The sum of whole tree is minimum, so return the root.
Example 2:

Input:
{1}
Output:1
Explanation:
The tree is look like this:
   1
There is one and only one subtree in the tree. So we return 1.
Notice
LintCode will print the subtree which root is your return node.


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
左右根 分治法
时间复杂度 o(N)


public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
            dfs(root);
            return minSubtree;
    }
    int min = Integer.MAX_VALUE;
    TreeNode minSubtree = new TreeNode(0);
    private int dfs(TreeNode node) {
        if (node == null) {
           return 0; 
        }    
        
        int sum = dfs(node.left) + dfs(node.right) + node.val;
        if (sum < min) {
            min = sum;
            minSubtree = node;
        }
        return sum;
    }
}