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
        
        boolean alter = true; // Variable for reversing the list each time it is added

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode node = dq.poll();
                tempList.add(node.val);
                if (node.left != null)
                    dq.add(node.left);
                if (node.right != null)
                    dq.add(node.right); 
            }
            if (!alter)
                Collections.reverse(tempList);
            alter = !alter;
            res.add(tempList);
        }
        return res;
    }
}