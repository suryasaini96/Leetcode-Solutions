class Solution {
    
    int MOD = 1000000007;
    
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3000][k+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(startPos, endPos, k, dp);
    }
    
    public int dfs(int start, int end, int k, int[][] dp) {
        if (start == end) {
            if (k == 0)
                return 1; // Exactly 1 way to reach when start == end and no steps left
        }
        
        if (k == 0) 
            return 0; // If 0 steps left also no way reach end
        
        if (dp[start+1000][k] != -1)
            return dp[start+1000][k]; // If we have the result already stored
        
        int left = dfs(start - 1, end, k - 1, dp);
        int right = dfs(start + 1, end, k - 1, dp);
        
        return dp[start+1000][k] = (left + right) % MOD;
    }
}