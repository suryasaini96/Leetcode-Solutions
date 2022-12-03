class Solution {
    public int[] sortByBits(int[] arr) {
        int[][] count = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int bits = countOneBits(arr[i]);
            count[i][0] = arr[i];
            count[i][1] = bits;
        }
        Arrays.sort(count, (int[] a, int[] b) -> {
            if (a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = count[i][0];
        }
        return arr;
    }
    
    private int countOneBits(int num) {
        int res = 0;
        while (num != 0) {
            res += (num & 1);
            num >>= 1;
        }
        return res;
    }
}