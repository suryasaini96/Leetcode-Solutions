class Solution {
    
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        HashSet<Integer> set = new HashSet<>();
        int evenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenSum += nums[i];
                set.add(i);
            }
        }
        int[] res = new int[queries.length]; int k = 0;
        for (int[] query: queries) {
            int val = query[0];
            int idx = query[1];
            evenSum = modify(set, evenSum, nums, val, idx);
            res[k++] = evenSum;
        }
        return res;
    }
    
    public int modify(HashSet<Integer> set, int evenSum, int[] nums, int val, int idx) {
        int prevVal = nums[idx];
        int currVal = prevVal + val;
        if (prevVal % 2 != 0 && currVal % 2 == 0) { // If prev was odd and new is even
            set.add(idx);
            evenSum += currVal;
        } else if (prevVal % 2 == 0 && currVal % 2 == 0) { // If prev was even and new is even
            set.add(idx);
            evenSum += val;
        } else if (prevVal % 2 == 0 && currVal % 2 != 0) { // If prev was even and curr is not even
            evenSum -= prevVal;
            set.remove(idx);
        }
        nums[idx] = currVal; // Modify the current index
        return evenSum;
    }
    
    
}