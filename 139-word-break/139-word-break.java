class Solution {
    
    // Bottom-up dp solution
    // Solution 1: from back 
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     int n = s.length();
    //     boolean[] dp = new boolean[n+1];
    //     dp[n] = true;
    //     Set<String> dict = new HashSet<>(wordDict);
    //     for (int i=n-1; i>=0; i--) {
    //         for (int j=i+1; j<=n; j++) {
    //             if (!dp[i] && dict.contains(s.substring(i,j)))
    //                 dp[i] = dp[j];
    //         }
    //     }
    //     return dp[0];
    // }
    
    // Solution 2: from start 
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        Set<String> dict = new HashSet<>(wordDict);
        for (int i=0; i<n; i++) {
            for (int j=i; dp[i] && j<n; j++) {
                String word = s.substring(i,j+1);
                if (dict.contains(word)) 
                    dp[j+1] = dp[i];
            }
        }
        return dp[n];
    }
    
    
    // Memoized recursive solution 
    
//     Boolean memo[];
    
//     public boolean wordBreak(String s, List<String> wordDict) {
//         memo = new Boolean[s.length()];
//         return wordBreak(0,s,new HashSet(wordDict));            
//     }
    
//     private boolean wordBreak(int i, String s, HashSet<String> wordDict) {
//         if (i == s.length()) return true;
//         if (memo[i]!=null) return memo[i];
//         for (int j=i+1; j<=s.length(); j++) {
//             String word = s.substring(i,j);
//             if (wordDict.contains(word) && wordBreak(j,s,wordDict))
//                 return memo[i]=true;
//         }
//         return memo[i]=false;
//     }
}