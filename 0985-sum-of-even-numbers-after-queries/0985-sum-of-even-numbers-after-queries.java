class Solution {
    
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenSum += nums[i];
            }
        }
        int[] res = new int[queries.length]; int k = 0;
        for (int[] query: queries) {
            int val = query[0];
            int idx = query[1];
            evenSum = modify(evenSum, nums, val, idx);
            res[k++] = evenSum;
        }
        return res;
    }
    
    public int modify(int evenSum, int[] nums, int val, int idx) {
        int prevVal = nums[idx];
        int currVal = prevVal + val;
        if (prevVal % 2 != 0 && currVal % 2 == 0) { // If prev was odd and new is even
            evenSum += currVal;
        } else if (prevVal % 2 == 0 && currVal % 2 == 0) { // If prev was even and new is even
            evenSum += val;
        } else if (prevVal % 2 == 0 && currVal % 2 != 0) { // If prev was even and curr is not even
            evenSum -= prevVal;
        }
        nums[idx] = currVal; // Modify the current index
        return evenSum;
    }
    
    
}