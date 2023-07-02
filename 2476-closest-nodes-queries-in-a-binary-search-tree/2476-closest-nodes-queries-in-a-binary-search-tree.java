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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        dfs(root, set); // Populate the tree set
        List<List<Integer>> res = new ArrayList<>();
        for (Integer q : queries) {
            Integer lower = null, higher = null;
            if (set.contains(q)) {
                lower = q;
                higher = q;
            } else {
                lower = set.lower(q) == null ? -1 : set.lower(q);
                higher = set.higher(q) == null ? -1 : set.higher(q);
            }
            res.add(Arrays.asList(lower, higher));
        }
        return res;
    }
    
    public void dfs(TreeNode root, TreeSet<Integer> set) {
        if (root == null) return;
        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }
}