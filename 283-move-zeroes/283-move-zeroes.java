class Solution {
    public void moveZeroes(int[] nums) {
        // Using 2 pointers approach
        
        int u = 0; int p = 1;
        while (p < nums.length) {
            if (nums[u] == 0 && nums[p]!= 0) { // swap if nums[u] is 0 and nums[p] is not 0
                int temp = nums[u];
                nums[u] = nums[p];
                nums[p] = temp;
            }
            if (nums[u]!=0)
                u++;
            p++; 
        }
    }
}