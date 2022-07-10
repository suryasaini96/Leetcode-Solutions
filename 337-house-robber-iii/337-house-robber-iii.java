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
    public int rob(TreeNode root) {
        int[] res = robHouse(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] robHouse(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        
        int[] left = robHouse(root.left);
        int[] right = robHouse(root.right);
        
        int[] res = new int[2];
        
        // 0 denotes when root is not included 
        // 1 denotes when root is included
        
        // When root is not included then result will be sum of max of left and right subtrees when root is included and not included respectively
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // When root is not included
        // When root is included then result will be sum of root value and left node and right node not included
        res[1] = root.val + left[0] + right[0];  // When root is included
        
        return res;
    }
}