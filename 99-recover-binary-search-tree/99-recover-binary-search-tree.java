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
    
    private TreeNode prev = null, first = null, second = null; 
    
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;    
    }
    
    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        if (prev != null && root.val < prev.val) { // Found the value not in order
            if (first == null)
                first = prev;
            second = root;
        }
        prev = root;
        inOrderTraversal(root.right);
    }
}