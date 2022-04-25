class Solution {
    
    // Using bottom-up approach
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for (int i=1; i<text1.length()+1; i++) {
            for (int j=1; j<text2.length()+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
    
//     // Using top-down memoized approach
//     public int longestCommonSubsequence(String text1, String text2) {
//         Integer[][] memo = new Integer[text1.length()][text2.length()];
//         return helper(text1, text2, 0, 0, memo);
//     }
    
//     private int helper(String a, String b, int i, int j, Integer[][] memo) {
//         if (i >= a.length() || j >= b.length())
//             return 0;
//         if (memo[i][j] != null)
//             return memo[i][j];
        
//         if (a.charAt(i) == b.charAt(j))
//             return memo[i][j] = 1 + helper(a, b, i+1, j+1, memo);
//         else
//             return memo[i][j] = Math.max(helper(a, b, i+1, j, memo), helper(a, b, i, j+1, memo));
//     }
    
}