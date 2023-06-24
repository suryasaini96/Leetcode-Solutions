class Solution {
    public int longestNiceSubarray(int[] nums) {
        int j = 0, num = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            while ((num & nums[i]) != 0) { // Bitwise and of num and nums[i] is not zero
                // Increase the value of j
                num ^= nums[j++]; // Removing start value by doing XOR
            } 
            num |= nums[i]; // Set the bits in num
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}