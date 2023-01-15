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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int minOps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                arr[i] = node.val;
            }
            minOps += countSwaps(arr);
        }
        return minOps;
    }
    
    private int countSwaps(int[] arr) {
        int swaps = 0;
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i); // Store the array with it's index
        }
        
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] != sortedArr[i]) {
                int index1 = map.get(sortedArr[i]);
                int index2 = map.get(arr[i]);
                
				// update index in map
                map.put(arr[i], index1);                      
                map.put(sortedArr[i], index2);
				
				// swap the numbers in original array with updated index
                arr[index1] = arr[i];
                arr[index2] = sortedArr[i];
                swaps++;
            }
        }
        return swaps;
    }
}