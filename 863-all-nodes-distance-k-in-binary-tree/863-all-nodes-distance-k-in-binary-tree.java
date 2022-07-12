/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Map<TreeNode, Integer> map = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        find(root, target);
        dfs(root, target, k, 0, res);
        return res;
    }
    
    // Find the distance of nodes towards target along the path from root to target
    private int find(TreeNode root, TreeNode target) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
    
    // Apply dfs to the tree and update the resultant list
    private void dfs(TreeNode root, TreeNode target, int k, int distance, List<Integer> res) {
        if (root == null)
            return;
        if (map.containsKey(root)) 
            distance = map.get(root);
        if (distance == k)
            res.add(root.val);
        dfs(root.left, target, k, distance + 1, res);
        dfs(root.right, target, k, distance + 1, res);
    }
    
}