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
    
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return balanced;
    }
    
    private int getHeight(TreeNode node) {
        // Adding below line to come out of recursion faster
        if (!balanced)
            return 0;
        
        if (node == null) {
            return -1;
        }
        
        int leftHeight = 1 + getHeight(node.left);
        int rightHeight = 1 + getHeight(node.right);
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
        }
        
        return Math.max(leftHeight, rightHeight);
    }
}