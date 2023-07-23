class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] nums = new int[n], res = new int[queries.length];
        int count = 0;
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0], color = queries[i][1];
            int prev = idx > 0 ? nums[idx-1] : 0;
            int next = idx < n - 1 ? nums[idx+1] : 0;
            if (nums[idx] != 0 && nums[idx] == prev) count--;
            if (nums[idx] != 0 && nums[idx] == next) count--;
            nums[idx] = color;
            if (nums[idx] == prev) count++;
            if (nums[idx] == next) count++;
            res[i] = count;
        }
        return res;
    }
}