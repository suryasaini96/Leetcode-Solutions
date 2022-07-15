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
    
    int count = 0;
    int kthMin = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root, k);
        return kthMin;
    }
    
    private void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            helper(root.left, k);
        }
        count--;
        if (count == 0) {
            kthMin = root.val;
            return;
        }
        if (root.right != null) {
            helper(root.right, k);
        }
    }
    
    // Using priority queue: O(log(n))
//     public int kthSmallest(TreeNode root, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
//         helper(root, k, pq);
//         return pq.poll();
//     }
    
//     private void helper(TreeNode root, int k, PriorityQueue<Integer> pq) {
//         if (root == null) {
//             return;
//         }
        
//         if (pq.size() == k && root.val < pq.peek()) {
//             pq.poll();
//             pq.add(root.val);
//         } else if (pq.size() < k) {
//             pq.add(root.val);
//         }
        
//         helper(root.left, k, pq);
//         helper(root.right, k, pq);
//     }
}