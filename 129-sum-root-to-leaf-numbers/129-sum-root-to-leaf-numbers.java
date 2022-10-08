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
    
    public int sumNumbers(TreeNode root) {
        return sum(root, "");
    }
    
    private int sum(TreeNode root, String num) {
        if (root == null) {
            return 0;   
        } 
        num += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            return Integer.parseInt(num);
        }
        int leftSum = sum(root.left, num);
        int rightSum = sum(root.right, num);
        return leftSum + rightSum;
    }
    
}