class Solution {
    
    int result = 0;
    
    public int countArrangement(int n) {
        int nums[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        permute(nums, n);
        return result;
    }

    private void permute(int nums[], int val) {
        if (val == 0) {
            result++; 
            return;
        }
        
        for (int i = val; i > 0; i--) {
            swap(nums, i, val);
            if (nums[val]%val==0 || val%nums[val]==0) {
                permute(nums, val-1);
            }
            swap(nums, i, val);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}