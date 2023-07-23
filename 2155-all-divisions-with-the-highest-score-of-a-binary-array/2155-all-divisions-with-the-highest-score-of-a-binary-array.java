class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n+1], suffixSum = new int[n+1], scores = new int[n+1];
        int zeroSum = 0, oneSum = 0, maxScore = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            prefixSum[i] += zeroSum;
            if (i < n && nums[i] == 0) zeroSum++;
        }
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] == 1) oneSum++;
            suffixSum[i] += oneSum;
        }
        for (int i = 0; i <= n; i++) {
            scores[i] = prefixSum[i] + suffixSum[i];
            maxScore = Math.max(maxScore, scores[i]);
        }
        for (int i = 0; i <= n; i++) {
            if (scores[i] == maxScore) {
                res.add(i);
            }
        }
        return res;
    }
}