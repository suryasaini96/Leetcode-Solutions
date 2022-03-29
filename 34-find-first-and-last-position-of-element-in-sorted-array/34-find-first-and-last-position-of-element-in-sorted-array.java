class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Using binarySearch to find first occurence of target
        int firstPos = findFirstOccurence(nums, target);
        // Using binarySearch to find last occurence of target
        int lastPos = findLastOccurence(nums, target);
        
        return new int[]{firstPos, lastPos}; 
     
    }
    
    
    static int findFirstOccurence(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        while (first <= last) {
            int mid = first + (last-first)/2;
            if (nums[mid] == target && (mid==0 || nums[mid-1] < target))
                return mid;
            else if (nums[mid] < target)
                first = mid+1;
            else 
                last = mid-1;

        }
        return -1;
    }
    
    static int findLastOccurence(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        while (first <= last) {
            int mid = first + (last-first)/2;
            if (nums[mid] == target && (mid==nums.length-1 || nums[mid+1] > target))
                return mid;
            else if (nums[mid] <= target)
                first = mid+1;
            else 
                last = mid-1;

        }
        return -1;
    }
}