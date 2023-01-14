class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long sum = 0;
        for (int j = 0, i = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                i = j + 1;
            } else {
                sum += j - i + 1;
            }
        }
        return sum;
    }
}