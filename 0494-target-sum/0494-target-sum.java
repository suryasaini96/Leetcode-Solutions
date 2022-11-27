class Solution {
    
    HashMap<String, Integer> memo = new HashMap<>();
    
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }
    
    public int dfs(int[] nums, int target, int i, int sum) {
        String serialVal = serialize(i, sum);
        if (memo.containsKey(serialVal)) {
            return memo.get(serialVal);
        }
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        int minusWays = dfs(nums, target, i+1, sum - nums[i]);
        int plusWays = dfs(nums, target, i+1, sum + nums[i]);
        
        int ways = minusWays + plusWays;
        memo.put(serialVal, ways);
        return ways;
    }
    
    public String serialize(int index, int sum) {
        return index + "," + sum;
    }
}