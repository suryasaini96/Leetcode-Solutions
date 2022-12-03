class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i-1];
        }
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if (start == 0) {
                res[i] = arr[end];
            } else {
                res[i] = arr[start-1] ^ arr[end];
            }
        }
        return res;
    }
}