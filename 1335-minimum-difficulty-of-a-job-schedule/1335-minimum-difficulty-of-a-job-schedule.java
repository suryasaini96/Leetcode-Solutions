class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) return -1;
        Integer dp[][] = new Integer[d+1][jobDifficulty.length];
        return helper(jobDifficulty, dp, d, 0);
    }
    
    private int helper(int[] jobDifficulty, Integer dp[][], int d, int index) {
        if (d == 1) {
            int max = 0;
            for (int i=index; i<jobDifficulty.length; i++) {
                max = Math.max(jobDifficulty[i], max);
            }
            return max;
        }
        if (dp[d][index]!=null) return dp[d][index];

        int max = 0;
        int ans = Integer.MAX_VALUE;
        for (int i=index; i<jobDifficulty.length-d+1; i++) {
            max = Math.max(jobDifficulty[i], max);
            ans = Math.min(ans, max + helper(jobDifficulty, dp, d-1, i+1));
        }
        return dp[d][index] = ans;
    }
}