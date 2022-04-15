class Solution {
    // public boolean divisorGame(int n) {
    //     return n%2 == 0;
    // }
    
    public boolean divisorGame(int n) {
        boolean dp[] = new boolean[n+1];
        dp[0] = false;
        dp[1] = false;
        for (int i=2; i<=n; i++) {
            for (int x=1; x<i; x++) { // Finding factors of n
                if (i%x==0) {
                    if (dp[i-x] == false) { // If bob loses on n-x then chose that x and set dp[i] as true
                        dp[i] = true;
                        break;
                    }
                }      
            }
        }
        return dp[n];
    }
}