class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] freq = new int[2];
        int start = 0, maxWindowSize = 0;
        for (int end = 0; end < nums.length; end++) {
            freq[nums[end]]++; // calc freq 
            int windowSize = end - start + 1; // calc window size
            // Window is invalid when freq of 0 is greater than k
            if (freq[0] > k) {
                freq[nums[start]]--; // Decrement freq of start
                start++; // increment start pointer
                windowSize--; // decrease window size
            }
            maxWindowSize = Math.max(maxWindowSize, windowSize);
        }
        return maxWindowSize;
    }
}