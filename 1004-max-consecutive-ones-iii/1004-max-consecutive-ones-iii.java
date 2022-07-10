class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, zeroCount = 0, maxWindowSize = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) zeroCount++;
            if (zeroCount > k) {
                if (nums[start] == 0) zeroCount--;
                start++;
            }
            maxWindowSize = Math.max(maxWindowSize, end - start + 1);
        }
        return maxWindowSize;
    }
}