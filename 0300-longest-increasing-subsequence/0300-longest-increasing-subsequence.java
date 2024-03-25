class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            int prevMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    int len = dp[j];
                    prevMax = Math.max(prevMax, len);
                }
            }
            dp[i] = prevMax + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}