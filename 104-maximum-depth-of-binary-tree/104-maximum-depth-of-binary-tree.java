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
    public int maxDepth(TreeNode root) {
        return findDepth(root, 1, 1);
    }
    
    private int findDepth(TreeNode root, int level, int maxDepth) {
        if (root == null) return 0;
        if (level > maxDepth) {
            maxDepth = level;
        }
        
        int leftDepth = findDepth(root.left, level + 1, maxDepth);
        int rightDepth = findDepth(root.right, level + 1, maxDepth);
        
        int maxOfBoth = Math.max(leftDepth, rightDepth);
        
        return Math.max(maxOfBoth, maxDepth);
    }
}