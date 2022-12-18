class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] != grid2[i][j]) {
                    setZeroDfs(grid2, i, j);
                }
            }
        }
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == grid2[i][j]) {
                    dfs(grid1, grid2, i, j);
                    count++;
                } 
            }
        }
        return count;
    }
    
    public void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length || grid2[i][j] == 0) {
            return;
        }
        if (grid1[i][j] == 1 && grid1[i][j] == grid2[i][j]) {
            grid2[i][j] = 0;
        } else {
            return;
        }
        
        dfs(grid1, grid2, i+1, j); // Next row
        dfs(grid1, grid2, i-1, j); // Top row
        dfs(grid1, grid2, i, j+1); // Next column
        dfs(grid1, grid2, i, j-1); // Prev column
    }
    
    public void setZeroDfs(int[][] grid2, int i, int j) {
        if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length || grid2[i][j] == 0) {
            return;
        }
        if (grid2[i][j] == 1) {
            grid2[i][j] = 0;
        }
        setZeroDfs(grid2, i+1, j); // Next row
        setZeroDfs(grid2, i-1, j); // Top row
        setZeroDfs(grid2, i, j+1); // Next column
        setZeroDfs(grid2, i, j-1); // Prev column
    }
}