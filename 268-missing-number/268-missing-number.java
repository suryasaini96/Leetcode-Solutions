class Solution {
    
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        int ans = sum;
        for (int i = 0; i < nums.length; i++) {
            ans -= nums[i];
        }
        return ans;
    }
    
    // public int missingNumber(int[] nums) {
    //     Arrays.sort(nums);
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] != i)
    //             return i;
    //     }
    //     return nums.length;
    // }
}