class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int minPenalty = 1;
        int maxPenalty = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            maxPenalty = Math.max(nums[i], maxPenalty);
        }
        
        int res = 0;
        // Applying binary search
        while (minPenalty <= maxPenalty) {
            int penalty = minPenalty + (maxPenalty - minPenalty)/2;
            // Calculate how many ops are needed using this penalty
            int ops = calculateOps(nums, penalty);
            if (ops <= maxOperations) {
                res = penalty;
                maxPenalty = penalty - 1; // Try to minimize the penalty
            } else { // Operations are more therefore penalty should be increased
                minPenalty = penalty + 1; // Increase the min penalty
            }   
        }
        return res;
    }
    
    private int calculateOps(int[] nums, int penalty) {
        int ops = 0;
        for (int i = 0; i < nums.length; i++) {
            // Only then ops will be calculated because it's more than penalty
            if (nums[i] > penalty) {
                if (nums[i]%penalty == 0) { // If nums[i] is direct multiple of penalty
                    ops += nums[i]/penalty - 1;
                } else {
                    ops += nums[i]/penalty;
                }
            }
        }
        return ops;
    }
}