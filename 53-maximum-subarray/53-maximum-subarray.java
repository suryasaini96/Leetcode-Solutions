class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
		int currSum = 0;
        int n = nums.length;
		for (int i=0; i<n; i++){
			currSum += nums[i];
			if (currSum>max)
				max = currSum;
			if (currSum<0)
				currSum = 0;	
		}
		return max;
    }
}