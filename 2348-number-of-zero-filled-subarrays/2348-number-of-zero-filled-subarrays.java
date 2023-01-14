class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long[] dp = new long[nums.length];
        dp[0] = nums[0] == 0 ? 1 : 0;
        long sum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (nums[i-1] == 0) {
                    dp[i] = dp[i-1] + 1;
                } else {
                    dp[i] = 1;
                }
            }
            sum += dp[i];
        }
        return sum;
    }
}