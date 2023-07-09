class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        long evenSumCount = 1;
        long oddSumCount = 0;
        long sum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] % MOD;
            if (sum % 2 == 0) {
                ans += oddSumCount;
                evenSumCount++;
            } else {
                ans += evenSumCount;
                oddSumCount++;
            }
            ans = ans % MOD;
        }
        return ans;
    }
}