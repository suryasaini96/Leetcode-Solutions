class Solution {
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i]-1])
                swap(nums, i, nums[i]-1);
        }
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return new int[] {nums[i], i+1};
            }
        }
        return new int[2];
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}