class Solution {
    public int minGroups(int[][] intervals) {
        int n = 10000000;
        int[] dp = new int[n];
        int max = -1;
        for (int i = 0; i < intervals.length; i++) {
            int a = intervals[i][0], b = intervals[i][1];
            dp[a]++;
            dp[b+1]--;
        }
        for (int i = 1; i < n; i++) {
            dp[i] += dp[i-1];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}