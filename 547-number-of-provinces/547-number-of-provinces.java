class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        
        int count = 0;
        for (int i=0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, i, n, visited);
            }
        }
        return count;
    }
    
    
    private void dfs(int[][] isConnected, int s, int n, boolean[] visited) {
        if (visited[s]) return;
        
        visited[s] = true;
        List<Integer> adj = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            int val = isConnected[s][j];
            if (val == 1) adj.add(j); 
        }
        
        for (Integer v: adj) {
            dfs(isConnected, v, n, visited);
        }
    }
    
}