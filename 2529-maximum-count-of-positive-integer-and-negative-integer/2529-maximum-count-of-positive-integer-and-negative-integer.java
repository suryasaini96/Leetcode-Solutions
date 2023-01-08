class Solution {
    public int maximumCount(int[] nums) {
        int minCount = 0, maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                minCount++;
            } else if (nums[i] > 0) {
                maxCount++;
            }
        }
        return Math.max(minCount, maxCount);
    }
}