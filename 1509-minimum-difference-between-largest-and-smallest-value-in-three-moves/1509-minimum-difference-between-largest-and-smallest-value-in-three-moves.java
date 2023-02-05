class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n < 5)
            return 0;
        Arrays.sort(nums);
        /*
        1. Kill biggest 3 elements.
        2. Kill first and last 2 elements.
        3. Kill first 2 and last 1 element.
        4. Kill smallest 3 elements.
        */
        int min1 = Math.min(nums[n-4] - nums[0], nums[n-3] - nums[1]);
        int min2 = Math.min(nums[n-2] - nums[2], nums[n-1] - nums[3]);
        return Math.min(min1, min2);
    }
}