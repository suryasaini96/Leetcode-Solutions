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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, 0, new ArrayList<>(), targetSum);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, TreeNode node, int sum, List<Integer> list, int targetSum) {
        if (node == null) return;
        sum += node.val;
        list.add(node.val);
        dfs(result, node.left, sum, list, targetSum);
        dfs(result, node.right, sum, list, targetSum);
        if (node.left == null && node.right == null && sum == targetSum) {
            result.add(new ArrayList<>(list));
        }
        list.remove(list.size()-1);
    }
}