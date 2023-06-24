class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int k = 0;
        // Fill less elemens
        for (int num : nums) {
            if (num < pivot) {
                res[k++] = num;
            }
        }
        
        // Fill equal to pivot
        for (int num : nums) {
            if (num == pivot) {
                res[k++] = num;
            }
        }
        
        // Fill greater than pivot
        for (int num : nums) {
            if (num > pivot) {
                res[k++] = num;
            }
        }
        
        return res;
    }
}