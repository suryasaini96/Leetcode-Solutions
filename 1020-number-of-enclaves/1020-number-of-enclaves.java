class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid, n, m);
            }
            if (grid[i][m-1] == 1) {
                dfs(i, m-1, grid, n, m);
            }
        }
        
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                dfs(0, j, grid, n, m);
            }
            if (grid[n-1][j] == 1) {
                dfs(n-1, j, grid, n, m);
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
        }
        return count;
    }
    
    private void dfs(int i, int j, int[][] grid, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0)
            return;
        
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
        }
        
        dfs(i-1, j, grid, n, m); // top
        dfs(i, j-1, grid, n, m); // left
        dfs(i, j+1, grid, n, m); // right
        dfs(i+1, j, grid, n, m); // down
    }
}