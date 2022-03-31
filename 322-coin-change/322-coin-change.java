class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1]; // Using 1-d DP array
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
        for (int coin: coins) {
            for (int a = coin; a <= amount; a++) {
                dp[a] = Math.min(dp[a], dp[a-coin] + 1);
            }
        }
        return dp[dp.length-1]==Integer.MAX_VALUE-1?-1:dp[dp.length-1];
    }
}