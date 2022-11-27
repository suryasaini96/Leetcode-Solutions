class Solution {
    
    int count = 0;
    
    public int findTargetSumWays(int[] nums, int target) {
        recursion(nums, target, 0, 0);
        return count;
    }
    
    public void recursion(int[] nums, int target, int i, int sum) {
        if (sum == target && i == nums.length) {
            count++;
        }
        if (i == nums.length) {
            return;
        }
        recursion(nums, target, i+1, sum + nums[i]);
        recursion(nums, target, i+1, sum - nums[i]);
    }
}