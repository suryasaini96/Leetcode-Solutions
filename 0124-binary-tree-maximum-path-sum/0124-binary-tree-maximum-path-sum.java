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
    
    Integer max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        
        max = Math.max(max, root.val);
        max = Math.max(max, root.val + leftMax);
        max = Math.max(max, root.val + rightMax);
        max = Math.max(max, root.val + leftMax + rightMax);
        
        return Math.max(root.val, root.val + Math.max(leftMax, rightMax));
    }
}