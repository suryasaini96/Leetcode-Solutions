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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        traverse(root, pq, k);
        return pq.peek();
    }
    
    public void traverse(TreeNode root, PriorityQueue<Integer> pq, int k) {
        if (root == null) return;
        
        if (pq.size() == k && root.val < pq.peek()) {
            pq.poll();
            pq.add(root.val);
        } else if (pq.size() < k) {
            pq.add(root.val);
        }
        
        traverse(root.left, pq, k);
        traverse(root.right, pq, k);
    }
}