class Solution {
    public void nextPermutation(int[] nums) {
        // 0 1 2 5 3 3 0
        /* Algorithm:
        1. Find the longest decreasing suffix
        2. Identify the pivot
        3. Find the rightmost successor to the pivot
        4. Swap the pivot with rightmost successor
        5. Reverse the suffix from pivot + 1 till end
        6. Done.
        */
        int pivot = findPivot(nums); 
        if (pivot != -1) {
            int rightIdx = findGreaterThanPivot(nums, nums[pivot]);
            swap(nums, pivot, rightIdx);
            reverseSuffix(nums, pivot+1);
        } else {
           reverseSuffix(nums, pivot + 1); // Reverse whole list if no pivot was found 
        }
    }
    
    
    private int findPivot(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i-1] < nums[i])
                return i-1;
        }
        return -1;
    }
    
    private int findGreaterThanPivot(int[] nums, int pivotEle) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > pivotEle)
                return i;
        }
        return -1;
    }
    
    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverseSuffix(int nums[], int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
        
    }
    
    
    
    
    
}