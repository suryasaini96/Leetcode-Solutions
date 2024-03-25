class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length() + 1];
        return dfs(s, 0, "", words, dp);
    }
    
    public boolean dfs(String str, int k, String word, Set<String> words, Boolean[] dp) {
        if (k == str.length()) 
            return dp[k] = true;
        if (dp[k] != null)
            return dp[k];
        for (int i = k; i < str.length(); i++) {
            word += str.charAt(i);
            if (words.contains(word) && dfs(str, i+1 , "", words, dp)) {
                return dp[i+1] = true;
            }  
        }
        return dp[k] = false;
    }
}