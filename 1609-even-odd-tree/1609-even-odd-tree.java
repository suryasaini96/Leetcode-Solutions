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
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            boolean evenLevel = false;
            if (level % 2 == 0) { // If it's an even level
                evenLevel = true;
            }
            
            if (evenLevel) {
                // All values should be odd in increasing order
                TreeNode node = q.poll();
                int prev = node.val;
                if (prev % 2 == 0) return false; // Previous value is even
                addNodes(q, node);
                for (int i = 1; i < sz; i++) {
                    node = q.poll();
                    int curr = node.val;
                    if (curr % 2 == 0) return false; // Curr value is even
                    if (prev >= curr) return false; // Should be strictly increasing
                    addNodes(q, node);
                    prev = curr;
                }
            } else {
                // All values should be even in decreasing order
                TreeNode node = q.poll();
                int prev = node.val;
                if (prev % 2 == 1) return false; // Previous value is odd
                addNodes(q, node);
                for (int i = 1; i < sz; i++) {
                    node = q.poll();
                    int curr = node.val;
                    if (curr % 2 == 1) return false; // Current value is odd
                    if (prev <= curr) return false; // Should be strictly decreasing
                    addNodes(q, node);
                    prev = curr;
                }
            }
            level++;
        }
        return true;
    }
    
    public void addNodes(Queue<TreeNode> q, TreeNode node) {
        if (node != null) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null)
                q.add(left);
            if (right != null)
                q.add(right);
        }
    }
}