class Solution {
    public void sortColors(int[] nums) {
        int start = 0; 
        int end = nums.length - 1;
        
        int count[] = new int[3];
        
        for (int i= 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            idx = setColors(nums, idx, count[i], i);
        }
    }
    
    
    private int setColors(int[] nums, int idx, int count, int val) {
        int c = 0;
        while (c < count) {
            nums[idx++] = val;
            c++;
        }
        return idx;
    }
} 