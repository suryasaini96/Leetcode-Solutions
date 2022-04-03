class Solution {
    
    // Brian Kernighan’s algorithm: Count number of n & n-1
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i=0; i<=n; i++) {
            int count = 0;
            int num = i;
            while (num > 0) {
                num = num & (num-1);
                count++;
            }
            result[i] = count;
        }
        return result;
    }
    
    // Count number of bits in each N -- nlog(n) solution
    // public int[] countBits(int n) {
    //     int[] result = new int[n+1];
    //     for (int i=0; i<=n; i++) {
    //         int count = 0;
    //         int num = i;
    //         while (num>0) {
    //             count += num & 1;
    //             num = num >> 1;
    //         }
    //         result[i] = count;
    //     }
    //     return result;
    // }
}