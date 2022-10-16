class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (start + end)/2;
            if (nums[mid] == target)
                return true;
            else if (nums[start] < nums[mid]) { // Left part is sorted
                if (target >= nums[start] && target < nums[mid])
                    end = mid;
                else
                    start = mid + 1;
            } else if (nums[start] > nums[mid]) { // Right part is sorted
                if (target > nums[mid] && target < nums[start])
                    start = mid + 1;
                else
                    end = mid;
            } else { // Start is equal to mid and target could lie anywhere
                start++;
            }
        }
        return false;
    }
}