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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        boolean alter = true; // Variable for deciding the zigzag order

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (alter) {
                    TreeNode node = dq.pollFirst();
                    tempList.add(node.val);
                    if (node.left != null)
                        dq.addLast(node.left);
                    if (node.right != null)
                        dq.addLast(node.right); 
                } else {
                    TreeNode node = dq.pollLast();
                    tempList.add(node.val);
                    if (node.right != null)
                        dq.addFirst(node.right); 
                    if (node.left != null)
                        dq.addFirst(node.left);
                }
            }
            alter = !alter;
            res.add(tempList);
        }
        return res;
    }
}