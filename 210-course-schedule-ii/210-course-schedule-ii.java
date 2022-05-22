class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Build the adjacency list first
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i=0; i < numCourses; i++)
            adj.add(i, new ArrayList<>());
        for (int j=0; j < prerequisites.length; j++)
            adj.get(prerequisites[j][1]).add(prerequisites[j][0]);
        
        // Making the boolean visited matrix
        boolean[] visited = new boolean[numCourses];
        boolean[] inLoop = new boolean[numCourses];
        // Doing depth first search on each node
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adj, i, stack, visited, inLoop))
                return new int[0]; // return an empty list
        }
        int i = 0;
        int[] result = new int[numCourses];
        while(!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }
    
    
    private boolean dfs(List<List<Integer>> adj, int v, Stack<Integer> stack, boolean[] visited, boolean[] inLoop) {
        if (visited[v]) return true;
        if (inLoop[v]) return false;
        
        inLoop[v] = true;
        for (Integer u: adj.get(v)) {
            if (!dfs(adj, u, stack, visited, inLoop))
                return false;
        }
        visited[v] = true;
        stack.push(v);
        return true;
    }
}