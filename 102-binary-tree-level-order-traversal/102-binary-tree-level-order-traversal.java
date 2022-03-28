/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();
        
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        q.add(root);

        while(!q.isEmpty()) {
           List<Integer> levelList = new ArrayList<Integer>();
           int currSize = q.size();
           for(int i=0; i<currSize; i++) {
               TreeNode node = q.poll();
               levelList.add((int)node.val);
               if (node.left !=null){
                   q.add(node.left);
               }
               if (node.right !=null){
                   q.add(node.right);
               }
           }
           result.add(levelList);
        }

        return result;
    }
}