class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k; // kth largest from the end
        // Partition the array till kth largest is in place at k positions from the end
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int idx = partition(nums, low, high);
            if (idx < k) { // kth largest would lie in the right part
                low = idx + 1;
            } else if (idx > k) { // kth largest would lie in the left part
                high = idx - 1;
            } else { // idx == k i.e. found the kth largest element 
                break;
            }
        }
        return nums[k];
    }
    
    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}