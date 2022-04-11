class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            int leftMax = 0;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i])
                    leftMax = Math.max(dp[j], leftMax); 
            }
            dp[i] = leftMax + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}