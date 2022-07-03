class Solution {
//     public void sortColors(int[] nums) {
//         int start = 0; 
//         int end = nums.length - 1;
        
//         int count[] = new int[3];
        
//         for (int i= 0; i < nums.length; i++) {
//             count[nums[i]]++;
//         }
        
//         int idx = 0;
//         for (int i = 0; i < 3; i++) {
//             idx = setColors(nums, idx, count[i], i);
//         }
//     }
    
    
//     private int setColors(int[] nums, int idx, int count, int val) {
//         int c = 0;
//         while (c < count) {
//             nums[idx++] = val;
//             c++;
//         }
//         return idx;
//     }
    
    // Put 0 at start and 2 at the end
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        for (int i=0; i<=end; i++) {
            // Put 2 at the end
            while (nums[i]==2 && i<end) 
                swap(nums, i, end--);
            // Put 0 at the start
            while (nums[i]==0 && i>start) 
                swap(nums, i, start++);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} 