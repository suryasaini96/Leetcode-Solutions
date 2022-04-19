class Solution {
    
    // Top-down memoized approach (more intuitive)
    public boolean isMatch(String s, String p) {
        Boolean memo[][] = new Boolean[s.length()+1][p.length()+1]; 
        return helper(s, p, 0, 0, memo);
    }
    
    // i and j are pointers for s and p respectively
    public boolean helper(String s, String p, int i, int j, Boolean memo[][]) {
        if (memo[i][j] != null)
            return memo[i][j];
        
        if (i >= s.length() && j >= p.length()) // If both i and j exceed their lengths then it's a match
            return true;
        else if (j >= p.length()) // If only j exceeds the length then it's not a match
            return false;
        
        boolean match = false;
        if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) // If both characters are equal or . then it's a match
            match = true;
            
        if (j+1 < p.length() && p.charAt(j+1) == '*') // Special case when next character is a *
            // If characters match then check next character in s OR check by skipping the character in p (along with *) 
            return memo[i][j] = match && helper(s, p, i+1, j, memo) || helper(s, p, i, j+2, memo);
            
        if (match)
            return memo[i][j] = helper(s, p, i+1, j+1, memo); // If both i and j match then check next characters of both
        return memo[i][j] = false; // Else characters don't match
    }
    
//     // Bottom-up DP solution
//     public boolean isMatch(String s, String p) {
//         boolean dp[][] = new boolean[p.length()+1][s.length()+1];
//         dp[0][0] = true; // Mark none matched with none as true
        
//         // Fill the 0th column
//         for (int i=1; i<p.length()+1; i++) {
//             if (p.charAt(i-1) == '*') // For 0th column only
//                 dp[i][0] = dp[i-2][0]; // The answer is 2 rows above only because can never include the previous character
//         }
        
//         // charAt functions have additional -1 because of dp size
//         for (int i=1; i<p.length()+1; i++) {
//             for (int j=1; j<s.length()+1; j++) {
//                 if (p.charAt(i-1) == '.' || p.charAt(i-1) == s.charAt(j-1)) // If charAt(i) is a '.' or charAt(j) == charAt(j)  
//                     dp[i][j] = dp[i-1][j-1]; // The solution is the same as diagonally (previous characters)
//                 else if (p.charAt(i-1) == '*') { // Special case when charAt(i) is a '*'
//                     if (dp[i-2][j] == true) // If 2 rows above is true (i.e not including * and it's previous character) 
//                         dp[i][j] = true;
//                     else if (p.charAt(i-1-1) == '.' || p.charAt(i-1-1) == s.charAt(j-1)) // If charAt(i-1) is a '.' or charAt(i-1) == charAt(j) (last characters before * are equal)
//                         dp[i][j] = dp[i][j-1]; // The solution is same as the left cell of i,j because we only need the result of previous character match (as the current is *)
//                 }
//             }
//         }
//         return dp[p.length()][s.length()];
//     }
}