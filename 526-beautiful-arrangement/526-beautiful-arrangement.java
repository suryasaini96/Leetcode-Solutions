class Solution {
    
    int result = 0;
    
    public int countArrangement(int n) {
        int nums[] = new int[n+1];
        permute(nums, 1, n);
        return result;
    }
    
    void permute(int[] nums, int val, int n) {
        if (val > n) {
            result++;
            return;
        }
        
        for (int i=1; i<=n; i++) {
            if (nums[i] == 0 && (val%i==0 || i%val==0)) {
                nums[i] = val;
                permute(nums, val + 1, n);
                nums[i] = 0;
            }
        }
    }
}