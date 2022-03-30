class Solution {
    
    // Using dynamic programming to optimize the solution
//     public int climbStairs(int n) {
//         int[] memo = new int[n+1];
//         Arrays.fill(memo, -1);
//         return climbStairs(n, memo);    
//     }
    
//     // Top down approach 
//     public int climbStairs(int n, int memo[]) {
//         if (n<0) return 0;
//         else if (n==0) return 1;
//         else if (memo[n] > -1) {
//             return memo[n];
//         } else {
//             memo[n] = climbStairs(n-1, memo) + climbStairs(n-2, memo);
//             return memo[n];
//         }
//     }
    
    // Bottom up approach
    public int climbStairs(int n) {
        if (n==0 || n==1) return n;
        int memo[] = new int[n];
        memo[0] = 1;
        memo[1] = 2;
        for (int i=2; i<n; i++){
            memo[i] = memo[i-1] + memo[i-2];       
        }
        return memo[n-1];
    }
    
    
    
    
    
    // O(2^n) solution because for every n we are calculating n-1th and n-2th step 
    // public int climbStairs(int n) {
    //     if (n<0) return 0;
    //     else if (n==0) return 1;
    //     else return climbStairs(n-1) + climbStairs(n-2); 
    // }
}