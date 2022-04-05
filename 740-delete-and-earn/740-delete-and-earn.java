class Solution {
    
    // Using dynamic programming approach
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001];
        int[] dp = new int[10001];
        // Store all the total sum of each element in array
        for (int num: nums)
            sum[num]+= num;
        
        dp[0] = 0;
        dp[1] = sum[1];
        for (int i=2; i<dp.length; i++) {
            dp[i] = Math.max(sum[i] + dp[i-2], dp[i-1]);
        }
        return dp[dp.length-1];
    }
        
    
//     // Recursive solution -- TLE 
//     public int deleteAndEarn(int[] nums) {
//         // Sort the array first so we don't have to include nums[i]-1 element
//         Arrays.sort(nums);
//         return solve(nums, 0); 
//     }
    
//     private int solve(int[] nums, int i) {
//         if (i >= nums.length)
//             return 0;
        
//         int currValue = nums[i];
//         int currSum = nums[i];
//         int index = i+1;
        
//         // Take all curr elements
//         while (index < nums.length && nums[index] == currValue)
//             currSum+= nums[index++];
        
//         int remIndex = index;
//         // Now skip curr + 1 elements
//         while (index < nums.length && nums[index] == currValue + 1)
//             index++;
        
//         // Either include currSum and solve for rest
//         // or exclude currValue and solve for remaining values 
//         return Math.max(currSum + solve(nums, index), solve(nums, remIndex));
            
//     }
}