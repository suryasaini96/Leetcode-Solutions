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
        for (int j = 0; j < n; j++) {
            if (isConnected[s][j] == 1 && !visited[j])
                dfs(isConnected, j, n, visited);
        }
    }
    
}