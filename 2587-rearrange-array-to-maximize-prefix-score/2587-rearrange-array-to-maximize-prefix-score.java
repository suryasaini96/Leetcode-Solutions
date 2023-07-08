class Solution {
    public int maxScore(int[] nums) {
        int len = nums.length, MOD = 1000000007;
        Arrays.sort(nums);
        long[] prefix = new long[len];
        prefix[len-1] = nums[len-1] % MOD;
        int score = prefix[len-1] > 0 ? 1 : 0;
        for (int i = len-2; i>=0; i--) {
            prefix[i] = nums[i] % MOD + prefix[i+1];
            if (prefix[i] > 0) {
                score++;
            } else {
                break;
            }
        }
        return score;
    }
}