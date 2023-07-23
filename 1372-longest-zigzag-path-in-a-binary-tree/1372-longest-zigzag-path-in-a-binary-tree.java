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
    
    int maxLength = Integer.MIN_VALUE;
    
    public int longestZigZag(TreeNode root) {
        zigZag(root, -1, 0);
        System.out.println();
        return maxLength;
    }
    
    public void zigZag(TreeNode root, int length, int prevDir) {
        if (root == null) return;
        maxLength = Math.max(length + 1, maxLength);
        if (prevDir == 0) {
            zigZag(root.left, length + 1, -1);
            zigZag(root.right, length + 1, 1);
        } else if (prevDir == 1) { // Prev direction was right
            zigZag(root.left, length + 1, -1);
            zigZag(root.right, 0, 1); // Reset length
        } else if (prevDir == -1) { // Prev direction was left
            zigZag(root.left, 0, -1); // Reset length
            zigZag(root.right, length + 1, 1);
        }
    }
}