class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i; dp[i] && j < n; j++) {
                String word = s.substring(i, j+1);
                if (words.contains(word)) {
                    dp[j+1] = dp[i];
                }
            }
        }
        return dp[n];
    }
}