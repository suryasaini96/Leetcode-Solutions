class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                grid[i][j] = 201;
                if (i > 0) grid[i][j] = Math.min(grid[i][j], grid[i-1][j] + 1);
                if (j > 0) grid[i][j] = Math.min(grid[i][j], grid[i][j-1] + 1);
            }
        }
        
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (grid[i][j] == 1) continue;
                if (i + 1 < m) grid[i][j] = Math.min(grid[i][j], grid[i+1][j] + 1);
                if (j + 1 < n) grid[i][j] = Math.min(grid[i][j], grid[i][j+1] + 1);
                max = Math.max(max, grid[i][j]);
            }
        }
        return max == 201 ? -1 : max - 1;
    }
}