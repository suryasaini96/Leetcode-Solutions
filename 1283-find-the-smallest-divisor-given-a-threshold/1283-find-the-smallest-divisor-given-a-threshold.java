class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int start = 1, end = nums[nums.length-1];
        int minDivisor = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start)/2;
            int sum = getSum(nums, mid);
            if (sum <= threshold) {
                minDivisor = Math.min(minDivisor, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            } 
        }
        return minDivisor;
    }
    
    private int getSum(int[] nums, int divisor) {
        Double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.ceil((double)nums[i]/divisor);
        }
        return sum.intValue();
    }
}