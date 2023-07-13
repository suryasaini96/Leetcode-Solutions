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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        dfs(root, null, adjList);
        HashSet<Integer> visited = new HashSet<>();
        int time = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited.add(start);
        while (!q.isEmpty() && adjList.containsKey(q.peek())) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int curr = q.poll();
                List<Integer> neighbours = adjList.get(curr);
                for (Integer neighbour : neighbours) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        q.add(neighbour);
                    }
                }
            }
            time++;
        }
        return time;
    }
    
    public void dfs(TreeNode root, TreeNode prev, HashMap<Integer, List<Integer>> adjList) {
        if (root == null) return;
        List<Integer> neighbours = new ArrayList<>();
        if (prev != null)
            neighbours.add(prev.val);
        if (root.left != null)
            neighbours.add(root.left.val);
        if (root.right != null)
            neighbours.add(root.right.val);
        adjList.put(root.val, neighbours);
        
        dfs(root.left, root, adjList);
        dfs(root.right, root, adjList);
    }
}