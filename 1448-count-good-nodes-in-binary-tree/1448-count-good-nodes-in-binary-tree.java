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
    
    int counter = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        counter++;
        helper(root.left, root.val);
        helper(root.right, root.val);
        return counter;
    }
    
    private void helper(TreeNode root, int maxSoFar) {
        if (root == null) {
            return;
        }
        
        if (root.val >= maxSoFar) {
            counter++;
            maxSoFar = root.val;
        }
        
        helper(root.left, maxSoFar);
        helper(root.right, maxSoFar);
    }
    
    
}