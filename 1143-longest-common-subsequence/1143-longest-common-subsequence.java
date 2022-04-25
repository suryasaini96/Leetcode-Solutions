class Solution {
    
    // Using top-down memoized approach
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length()][text2.length()];
        return helper(text1, text2, 0, 0, memo);
    }
    
    private int helper(String a, String b, int i, int j, Integer[][] memo) {
        if (i >= a.length() || j >= b.length())
            return 0;
        if (memo[i][j] != null)
            return memo[i][j];
        
        if (a.charAt(i) == b.charAt(j))
            return memo[i][j] = 1 + helper(a, b, i+1, j+1, memo);
        else
            return memo[i][j] = Math.max(helper(a, b, i+1, j, memo), helper(a, b, i, j+1, memo));
    }
    
}