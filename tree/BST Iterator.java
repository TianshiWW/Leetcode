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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
解法：
无限递归到最左边node
取点的时候注意如果有右边node，递归到右边的节点，再无限递归到左边
                        10
                      /    \
                     5      19
                    /  \
                   4    7
                      /   \
                     6      9

    如下，初始化时stack存 [10,5,4
        取出4以后，node为5
        下一轮的时候，先把5取出来，发现5有右边节点  
        if(res.right != null ) {
            res = res.right;    
            while (res != null) {
                stack.add res; 
                res = res.left;
            }
        }   

    trick:  res 和 node 用临时变量
            不要不小心把空加进去 while里先加node 再node = node.left

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    /*
    * @param root: The root of binary tree.
    */public BSTIterator(TreeNode root) {
        // do intialization if necessary
        while (root != null) {
            stack.push(root);
            root = root.left;
            
        }
        //System.out.println(stack.size());
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode node = stack.pop();
        TreeNode res = node;
        if (res.right != null) {
           res = res.right;
           while(res != null) {
               stack.add(res);
               res = res.left;
           }
        }
        return node;
    }
}