/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        //连接头尾
        first.left = last;
        last.right = first;
        return first;
    }
    /**
    * 无限递归左边 中序遍历左中右
        // cur.left = last;
        // last.right = cur; 连接
        // if(last == null), 说明是第一个，那first = cur; 
        //统一last = cur
    */
    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }        
        dfs(cur.left);
        if (last == null) {
            first = cur;
        } else {
            cur.left = last;
            last.right = cur;
        }
        last = cur;
        dfs(cur.right);
        return;
    }
}