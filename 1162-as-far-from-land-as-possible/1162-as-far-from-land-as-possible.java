class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = -1, INF = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                int top = INF, left = INF;
                if (i-1 >= 0)
                    top = grid[i-1][j];
                if (j-1 >= 0)
                    left = grid[i][j-1];
                
                if (top == INF && left == INF)
                    grid[i][j] = INF;
                else
                    grid[i][j] = Math.min(top, left) + 1;
            }
        }
        
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (grid[i][j] == 1) continue;
                int right = INF, down = INF;
                if (i + 1 < m)
                    down = grid[i+1][j];
                if (j + 1 < n)
                    right = grid[i][j+1];
                int min = Math.min(right, down);
                min = min == INF ? INF : min + 1;
                grid[i][j] = Math.min(grid[i][j], min);
                max = Math.max(max, grid[i][j]);
            }
        }
        return (max == Integer.MAX_VALUE || max == -1) ? -1 : max-1;
    }
}