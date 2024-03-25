class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int pivot = findPivot(nums);
        // Check where the target lies
        if (target >= nums[pivot] && target <= nums[end])
            start = pivot;
        else 
            end = pivot - 1;
        
        // Apply binary search to find the target
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) 
                start = mid + 1;
            else 
                end = mid - 1;
        }
        return -1;
    }
    
    public int findPivot(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}