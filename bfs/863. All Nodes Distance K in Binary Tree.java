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
    Map<TreeNode,List<TreeNode>> graph = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        
        dfs(root,root.left);
        dfs(root,root.right);
        
//         for (TreeNode key : graph.keySet()) {
//             List<TreeNode> sons = graph.get(key);
//             System.out.print("key: " + key.val + "'s son'");
//             for(TreeNode son : sons){
//                 System.out.print(son.val + ",");
//             }
//             System.out.println();
            
//         }
        
//         System.out.print(graph.size());
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                while(!q.isEmpty()) {
                    // System.out.println("!"+q.peek().val);
                    res.add(q.poll().val);
                }
            }
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                visited.add(curr);
                
                if(curr == null) {
                    System.out.print("~~~");
                }
                // if (graph.get(curr) != null) {
                //    System.out.print(curr.val); 
                // }
                //System.out.print(curr.val);
                if (graph.get(curr) == null) {
                    //System.out.println("now null" + curr);
                   continue; 
                }
                for (TreeNode next: graph.get(curr)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    q.offer(next);
                }
            }
            K--;
        }
        return res;
        
    }
    
    private void dfs(TreeNode parent, TreeNode son) {
        if (son == null || parent == null) {
            return;
        }
        if (!graph.containsKey(parent)) {
            List<TreeNode> sons = new ArrayList<>();
            graph.put(parent,sons);
        }
        if (!graph.containsKey(son)) {
            List<TreeNode> sons = new ArrayList<>();
            graph.put(son,sons);
        }
        
//         if (son == null) {
//            System.out.println("son null"); 
//         }
        
//         if (parent == null) {
//            System.out.println("parent null"); 
//         }
        
        graph.get(son).add(parent);
        graph.get(parent).add(son);
        
        if(son.left != null) {
            dfs(son,son.left);   
        }
        
        if(son.right != null) {
            dfs(son,son.right);   
        }
       // dfs(son,son.right);
        return;
    }
    
}