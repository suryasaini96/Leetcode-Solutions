class Solution {
    public int findMin(int[] nums) {
        int pivot = findPivot(nums);
        return nums[pivot];
    }
    
    private int findPivot(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] <= nums[end])
                break;
            int mid = (start + end)/2;            
            if (nums[start] <= nums[mid]) { // If left part is sorted
                start = mid + 1;
            } else { // If right part is sorted
                end = mid;
            }
        }
        return start;
    }
}