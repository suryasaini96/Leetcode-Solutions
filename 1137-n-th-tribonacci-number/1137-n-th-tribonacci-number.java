class Solution {
    
    // Using bottom up dynamic programming approach
    public int tribonacci(int n) {
        if (n==0 || n==1) return n;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        for (int i=3; i<=n; i++) {
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }
        return memo[n];     
    }
}