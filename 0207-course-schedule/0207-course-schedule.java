class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {    
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] memo = new boolean[numCourses];
        boolean[] vis = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if (adjList.containsKey(b)) {
                List<Integer> adj = adjList.get(b);
                adj.add(a);
            } else {
                List<Integer> adj = new ArrayList<>();
                adj.add(a);
                adjList.put(b, adj);
            }
        }
        
        for (int i = 0; i < numCourses - 1; i++) {
            if (!dfs(i, vis, adjList, memo)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int course, boolean[] vis, HashMap<Integer, List<Integer>> adjList, boolean[] memo) {
        if (vis[course])
            return false;
        if (memo[course])
            return true;        
        vis[course] = true;
        List<Integer> list = adjList.get(course);
        if (list != null) {
            for (Integer adj : list) {
                if (!dfs(adj, vis, adjList, memo))
                    return false;
            }
        }
        vis[course] = false;
        memo[course] = true;
        return true;
    }
}