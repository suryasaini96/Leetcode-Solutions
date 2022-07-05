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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        dq.add(root);
        while(!dq.isEmpty()) {
            TreeNode rightViewNode = dq.peekLast();
            result.add(rightViewNode.val);
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = dq.poll();
                if (node.left != null) {
                    dq.add(node.left);
                }
                if (node.right != null) {
                    dq.add(node.right);
                }
            }
        } 
        return result;
    }
}