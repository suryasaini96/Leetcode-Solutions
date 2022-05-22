class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean flag = false;
        for (int i=0; i<grid.length && !flag; i++) {
            for (int j=0; j<grid[0].length && !flag; j++) {
                if (grid[i][j] == 1) { // Find the first 1
                    dfs(grid, i, j, q);
                    flag = true;
                    break;
                }
            }
        }
        return bfs(grid, q);            
    }
    
    private void dfs(int[][] grid, int i, int j, Queue<int[]> q) {
        if (i < 0 || i>=grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] == 0)
            return;
        
        grid[i][j] = -1; // Mark the point as visited
        q.offer(new int[]{i, j});
        
        // Apply DFS to all 4 directions
        dfs(grid, i-1, j, q); // top
        dfs(grid, i, j-1, q); // left
        dfs(grid, i+1, j, q); // down
        dfs(grid, i, j+1, q); // right    
    }
    
    
    private int bfs(int[][] grid, Queue<int[]> q) {
        int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        // Top, right, down, left
        
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size(); 
            while (size-- > 0) {
                int[] temp = q.poll();
                for (int[] dir: dirs) {
                    int i = temp[0] + dir[0];
                    int j = temp[1] + dir[1];
                    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1)
                        continue;
                    if (grid[i][j] == 1)
                        return level;
                    else { 
                        grid[i][j] = -1;
                        q.offer(new int[]{i, j});
                    }
                }
            }
            level += 1;
        }
        return -1;
    }
}