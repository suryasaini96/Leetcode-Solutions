class Solution {
    
    Boolean[] completedCourses;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        completedCourses = new Boolean[numCourses];
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
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
            if (isCyclic(i, vis, adjList)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isCyclic(int course, boolean[] vis, HashMap<Integer, List<Integer>> adjList) {
        if (vis[course])
            return true;
        if (completedCourses[course] != null) {
            return false;
        }
        completedCourses[course] = true;
        vis[course] = true;
        List<Integer> list = adjList.get(course);
        if (list != null) {
            for (Integer adj : list) {
                if (isCyclic(adj, vis, adjList))
                    return true;
            }
        }
        vis[course] = false;
        return false;
    }
}