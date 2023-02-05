class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // Iterate from the start and try to find the value which
        // is less than the max value so far
        int max = nums[0];
        int end = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                end = i;
            }
        }
        
        // Iterate from the end and try to find the value which
        // is more than the min value so far
        int min = nums[nums.length-1];
        int start = 0;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                start = i;
            }
        }
        return end - start + 1;
    }
}