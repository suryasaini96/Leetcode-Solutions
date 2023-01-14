class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length <= 1) {
            return 1;
        }
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int sign = 0;
        if (arr[0] == arr[1]) {
            dp[1] = 1;
            sign = 0;
        } else if (arr[1] < arr[0]) {
            dp[1] = 2;
            sign = -1;
        } else if (arr[1] > arr[0]) {
            dp[1] = 2;
            sign = 1;
        }
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                int currSign = -1;
                if (sign < 0) { // If the sign is already decreasing
                    dp[i] = 2; // Restart the subarray & sign stays the same
                } else if (currSign != sign) {
                    dp[i] = dp[i-1] + 1;
                }
                sign = -1;
            } else if (arr[i] == arr[i-1]) {
                sign = 0;
                dp[i] = 1;
            } else if (arr[i] > arr[i-1]) {
                int currSign = 1;
                if (currSign != sign) {
                    dp[i] = dp[i-1] + 1;
                } else if (sign > 0) {
                    dp[i] = 2; // Restart the subarray & sign stays the same
                }
                sign = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}