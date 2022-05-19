class Solution {
    public int firstMissingPositive(int[] nums) {
        // Linearly traverse the array and try to put the element at it's place in the array
        int n = nums.length;
        // If number is out of bounds or -ve then ignore
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <= n && nums[i] > 0 && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }
        
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] != i+1)
                return i+1;
        }
        
        return nums.length + 1;
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}