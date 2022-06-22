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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        paths(root, new StringBuilder(), result);
        return result;
    }
    
    private void paths(TreeNode root, StringBuilder path, List<String> result) {
        if (root == null) {
            return;
        }
        int currLength = path.length();
        if (root.left == null && root.right == null) {
            path.append(root.val);
            result.add(path.toString());
            path.delete(currLength, path.length());
            return;
        }     
        path.append(root.val + "->");
        paths(root.left, path, result);
        paths(root.right, path, result);
        path.delete(currLength, path.length());
    }
}