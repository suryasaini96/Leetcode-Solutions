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

    int paths = 0;
    
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1); // Put 0 frequency as 1
        helper(root, targetSum, 0, freqMap);
        return paths;
    }
    
    private void helper(TreeNode root, int targetSum, int currSum, HashMap<Integer, Integer> freqMap) {
        if (root == null) {
            return;
        }
        
        currSum += root.val;    
        if (freqMap.containsKey(currSum - targetSum)) { // If currSum - targetSum is seen again then middle part must have summed to k
            paths += freqMap.get(currSum - targetSum); // Add the paths 
        }
        freqMap.put(currSum, freqMap.getOrDefault(currSum, 0) + 1); // Increase currSum count 
        
        helper(root.left, targetSum, currSum, freqMap);
        helper(root.right, targetSum, currSum, freqMap);
        
        if (freqMap.containsKey(currSum)) {
            freqMap.put(currSum, freqMap.get(currSum) - 1); // Decrease currSum frequency
        }    
    }
}