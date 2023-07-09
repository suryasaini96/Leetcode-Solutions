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
    
    int maxLevel = 0;
    int deepestLevelSum = 0;
    
    public int deepestLeavesSum(TreeNode root) {
        getMaxLevel(root, 0);
        dfs(root, 0);
        return deepestLevelSum;
    }
    
    public void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (level == maxLevel)
            deepestLevelSum += root.val;
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
    
    public void getMaxLevel(TreeNode root, int level) {
        if (root == null)
            return;
        if (level > maxLevel) 
            maxLevel = level;
        getMaxLevel(root.left, level + 1);
        getMaxLevel(root.right, level + 1);
    }
}