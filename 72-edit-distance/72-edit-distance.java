class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        
        // Filling the last column
        for (int i=n; i>=0; i--)
            dp[i][m] = n-i;
        
        // Filling the last row
        for (int j=0; j<=m; j++)
            dp[n][j] = m-j;
        
        // Filling the dp table from 2nd last row and column onwards
        for (int i=n-1; i>=0; i--) {
            for (int j=m-1; j>=0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) // Then we don't need to do any operation so result will be same as i+1, j+1
                    dp[i][j] = dp[i+1][j+1];
                else { // add 1 to Minimum operation of inserting, deleting and replacing a character
                    // Inserting --> i, j+1  Deleting --> i+1, j  Replacing --> i+1, j+1
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}