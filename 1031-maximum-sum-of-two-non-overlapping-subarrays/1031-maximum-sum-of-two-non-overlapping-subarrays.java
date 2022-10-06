class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(helper(nums, firstLen, secondLen), helper(nums, secondLen, firstLen));
    }
    
    private int helper(int[] nums, int firstLen, int secondLen) {
        int sum = 0;
        int[] maxPrefixSum = new int[nums.length];
        int[] maxSuffixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < firstLen) {
                sum += nums[i];
                maxPrefixSum[i] = sum;
            } else {
                sum += nums[i] - nums[i - firstLen];
                maxPrefixSum[i] = Math.max(maxPrefixSum[i-1], sum);
            }
        }
        
        sum = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            if (i + secondLen > nums.length - 1) {
                sum += nums[i];
                maxSuffixSum[i] = sum;
            } else {
                sum += nums[i] - nums[i+secondLen];
                maxSuffixSum[i] = Math.max(maxSuffixSum[i+1], sum);
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = firstLen-1; i < nums.length - secondLen; i++) {
            max = Math.max(max, maxPrefixSum[i] + maxSuffixSum[i+1]);        
        }
        return max;
    }
}