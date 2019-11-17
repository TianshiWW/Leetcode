376. Binary Tree Path Sum

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


public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,target,root.val,path,res);
        //path.remove(root.val);
        return res;
    }
    
    private void dfs(TreeNode root, int target, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root.left == null && root.right == null) {
            if (sum == target) {
               res.add(new ArrayList(path));
            }
            return;
        }
        
        if (root.left != null) {
            sum += root.left.val;
            path.add(root.left.val);
            dfs(root.left, target, sum, path, res);
            path.remove(path.size() - 1);
            sum -= root.left.val;
        }
        
        if (root.right != null) {
            sum += root.right.val;
            path.add(root.right.val);
            dfs(root.right, target, sum, path, res);
            path.remove(path.size() - 1);
            sum -= root.right.val;
        }
        
        return;
    }
}