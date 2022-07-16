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
    public int widthOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, 1, 0, new ArrayList<Integer>(), res);
        return res[0];
    }
    
    private void dfs(TreeNode root, int i, int depth, List<Integer> left, int[] res) {
        if (root == null) {
            return;
        }
        if (depth >= left.size()) {
            left.add(i);
        }
        res[0] = Math.max(res[0], i - left.get(depth) + 1);
        dfs(root.left, i*2, depth + 1, left, res);
        dfs(root.right, i*2 + 1, depth + 1, left, res); 
    }
    
    
}