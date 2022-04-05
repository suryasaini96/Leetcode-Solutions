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
            dp[i] = Math.max(sum[i] + dp[i-2], dp[i-1]); // Ignore adjacent elements if taking sum[i] else the answer would be dp[i-1]  
        }
        return dp[dp.length-1];
    }
    
//     // Other dp approach 
//     public int deleteAndEarn(int[] nums) {
//         int inc = 0; int exc = 0;
//         int freq[] = new int[10001];
        
//         for (int val: nums)
//             freq[val]++;
        
//         for (int i=0; i<freq.length; i++) {
//             int newInc = exc + freq[i]*i; // Include total num[i]
//             int newExc = Math.max(inc,exc);
            
//             inc = newInc;
//             exc = newExc;
//         }
//         return Math.max(inc,exc);
//     }    
            
        
    
//     // Recursive solution with memoization
//     Integer[] memo = new Integer[20001];
    
//     public int deleteAndEarn(int[] nums) {
//         // Sort the array first so we don't have to include nums[i]-1 element
//         Arrays.sort(nums);
//         return solve(nums, 0); 
//     }
    
//     private int solve(int[] nums, int i) {
//         if (i >= nums.length)
//             return 0;
        
//         if (memo[i]!=null)
//             return memo[i];
        
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
//         return memo[i] = Math.max(currSum + solve(nums, index), solve(nums, remIndex));
            
//     }
}