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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0,nums.length-1,nums);
    }
    
    private TreeNode dfs(int left, int right, int[] nums) {
        if (left > right) {
           return null; 
        }
        
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(left,mid-1,nums);
        node.right = dfs(mid+1,right,nums);
        return node;
    }
}