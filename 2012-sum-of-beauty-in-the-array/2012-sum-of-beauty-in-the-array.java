class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] maxFromLeft = new int[n];
        int[] minFromRight = new int[n];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        // Finding max from left for i
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i-1]);
            maxFromLeft[i] = max;
        }
        // Finding min from right for i
        for (int i = n - 2; i >= 0; i--) {
            min = Math.min(min, nums[i+1]);
            minFromRight[i] = min;
        }
        
        int beauty = 0;
        for (int i = 1; i <= n - 2; i++) {
            if (maxFromLeft[i] < nums[i] && nums[i] < minFromRight[i]) {
                beauty += 2;
            } else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                beauty += 1;
            }
        }
        return beauty;
    }
}