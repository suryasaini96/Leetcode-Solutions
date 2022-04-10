class Solution {
    // DP solution
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int dp[][] = new int[rows+1][cols+1];
        
        int max = 0;    
        for (int i=1; i<=rows; i++) {
            for (int j=1; j<=cols; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]);
                    if (dp[i][j] > max)
                        max = dp[i][j];
                }
            }
        }
        return max*max;
    }
    
//     // Top-down memoization solution
//     public int maximalSquare(char[][] matrix) {
//         int rows = matrix.length;
//         int cols = matrix[0].length;
//         int max = 0;
//         Integer memo[][] = new Integer[rows][cols];
//         for (int i=0; i<rows; i++) {
//             for (int j=0; j<cols; j++) {
//                 max = Math.max(max, helper(i,j,matrix,memo));
//             }
//         }
//         return max*max;
//     }
    
//     private int helper(int i, int j, char[][] matrix, Integer[][] memo) {
//         if (i==0 || j==0) return matrix[i][j] - '0';
//         if (matrix[i][j] == '0') return 0;
//         if (memo[i][j]!=null) return memo[i][j];
//         return memo[i][j] = 1 + Math.min(Math.min(helper(i-1,j,matrix,memo), helper(i,j-1,matrix,memo)), helper(i-1,j-1,matrix,memo));
//     }
}