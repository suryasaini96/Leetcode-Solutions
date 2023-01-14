class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        // Fill the dp array with -1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // Fill the last row values
        for (int j = 0; j < grid[0].length; j++) {
            dp[grid.length-1][j] = grid[grid.length-1][j];
        }
        
        Integer min = Integer.MAX_VALUE;
        for (int j = 0; j < grid[0].length; j++) {
            min = Math.min(min, recurse(dp, grid, 0, j));
        }
        return min;
    }
    
    public int recurse(int[][] dp, int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        Integer min = Integer.MAX_VALUE;
        for (int col = 0; col < grid[0].length; col++) {
            if (col != j) {
                min = Math.min(min, recurse(dp, grid, i+1, col));
            }   
        }
        return dp[i][j] = grid[i][j] + min;
    }
}