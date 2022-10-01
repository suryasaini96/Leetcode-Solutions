class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxSoFar = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else if (nums[i] == 0) {
                count = 0;
            }
            maxSoFar = Math.max(maxSoFar, count);
        }
        return maxSoFar;
    }
}