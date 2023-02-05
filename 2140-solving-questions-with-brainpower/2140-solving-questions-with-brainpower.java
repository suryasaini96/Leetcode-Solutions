class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];
        long max = 0;
        for (int i = n-1; i >= 0; i--) {
            int points = questions[i][0];
            int jumps = questions[i][1];
            int jumpIndex = Math.min(jumps + i + 1, n);
            dp[i] = Math.max(dp[i+1], points + dp[jumpIndex]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}