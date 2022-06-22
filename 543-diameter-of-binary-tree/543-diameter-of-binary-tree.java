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
    Integer diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }
    
    // Approach: At any node - find the deepest to the left and deepest to the right and add the two to find max
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int deepestToLeft = helper(root.left);
        int deepestToRight = helper(root.right);
        
        diameter = Math.max(diameter, deepestToLeft + deepestToRight);
        
        return Math.max(deepestToLeft, deepestToRight) + 1;
    }
    
}