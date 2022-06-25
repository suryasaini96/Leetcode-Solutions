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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }
    
    private TreeNode merge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null && root2 != null) {
            TreeNode newNode = new TreeNode(root2.val);
            TreeNode leftNode = merge(null, root2.left);
            TreeNode rightNode = merge(null, root2.right);
            newNode.left = leftNode;
            newNode.right = rightNode;
            return newNode;
        }
        if (root1 != null && root2 == null) {
            TreeNode newNode = new TreeNode(root1.val);
            TreeNode leftNode = merge(root1.left, null);
            TreeNode rightNode = merge(root1.right, null);
            newNode.left = leftNode;
            newNode.right = rightNode;
            return newNode;
        }
        
        TreeNode newNode = new TreeNode(root1.val + root2.val);
        TreeNode leftNode = merge(root1.left, root2.left);
        TreeNode rightNode = merge(root1.right, root2.right);
        newNode.left = leftNode;
        newNode.right = rightNode;
        return newNode;
    }
}