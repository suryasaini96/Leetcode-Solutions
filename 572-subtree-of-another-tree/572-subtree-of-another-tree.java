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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        
        boolean res = false;
        if (root.val == subRoot.val) {
            res = checkValues(root, subRoot);
        }
        
        return res || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean checkValues(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null && subRoot != null || root != null && subRoot == null) 
            return false;
        if (root.val != subRoot.val)
            return false;
        return checkValues(root.left, subRoot.left) && checkValues(root.right, subRoot.right);
    }
}