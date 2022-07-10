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
        return robHouse(root, new HashMap<>());
    }
    
    private int robHouse(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        
        int res = 0;
        if (root.left != null) {
            res += robHouse(root.left.left, map) + robHouse(root.left.right, map);
        }
        if (root.right != null) {
            res += robHouse(root.right.left, map) + robHouse(root.right.right, map);
        }
        
        res = Math.max(res + root.val, robHouse(root.left, map) + robHouse(root.right, map));
        map.put(root, res);
        return res;
    }
}