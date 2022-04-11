class Solution {
    
    // DP solution
    public int knightDialer(int n) {
        // F(n,d) = F(n-1,x) + F(n-1,y);  // n - no of steps, d - digit, x & y are digits from which digit d could be reached
        // Examples:-
        // F(2,1) = F(1,6) + F(1,8);  
        // F(2,0) = F(1,4) + F(1,6);
        // F(2,4) = F(1,0) + F(1,3) + F(1,9);
        // Final answer would be F(n) = Sum of F(n,d) where d goes from 0 to 9
        
        int MOD = 1000000007;
        int paths[][] = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        long dp[][] = new long[n+1][10];
        // Fill the 1st row (1 step with 1)
        for (int j=0; j<10; j++) {
             dp[1][j] = 1;
        }
    
        // Start traversing 2nd row (2 steps onwards)
        for (int i=2; i<n+1; i++) {
            for (int j=0; j<10; j++) {
                for (int path: paths[j])
                    dp[i][j] += dp[i-1][path];
                dp[i][j] = dp[i][j] % MOD;
            }
        }
        
        long sum = 0;
        // Answer for F(N) would be sum of the last row in the dp matrix
        for (int j=0; j<10; j++)
            sum+= dp[n][j];
        
        return (int)(sum%MOD);
    }
    
//     // Memoization solution
//     static final int MOD = 1000000007;
    
//     public int knightDialer(int n) {
        
//         int paths[][] = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
//         int count = 0;
//         Integer memo[][] = new Integer[n+1][10];
//         for (int i=0; i<10; i++) {
//             count = (count + helper(n-1, i, paths, memo))%MOD;
//         }
//         return count;
//     }
    
//     public int helper(int n, int d, int[][] paths, Integer memo[][]) {
//         if (n==0) return 1;
//         if (memo[n][d] != null) return memo[n][d];
        
//         int count = 0;
//         for (int p: paths[d]) {
//             count = (count + helper(n-1, p, paths, memo)) % MOD;
//         }
//         return memo[n][d] = count;
//     }
}