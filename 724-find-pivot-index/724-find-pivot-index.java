class Solution {
    public int pivotIndex(int[] nums) {
        // Left prefix sum should be equal to right suffix sum 
        int prefixSum[] = new int[nums.length]; int suffixSum[] = new int[nums.length];
        int p = 1; int s = nums.length - 2;
        
        // Building prefixSum and suffixSum
        while (p <= nums.length - 1) {
            prefixSum[p] = prefixSum[p-1] + nums[p-1];
            suffixSum[s] = suffixSum[s+1] + nums[s+1];
            p++; s--;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (prefixSum[i] == suffixSum[i])
                return i;
        }
        return -1;
    }
}