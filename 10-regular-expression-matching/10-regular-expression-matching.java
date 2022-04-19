class Solution {
    public boolean isMatch(String s, String p) {
        Boolean memo[][] = new Boolean[s.length()+1][p.length()+1]; 
        return helper(s, p, 0, 0, memo);
    }
    
    // Top-down memoized approach
    public boolean helper(String s, String p, int i, int j, Boolean memo[][]) {
        if (memo[i][j] != null)
            return memo[i][j];
        
        if (i >= s.length() && j >= p.length())
            return true;
        else if (j >= p.length())
            return false;
        
        boolean match = false;
        if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))
            match = true;
            
        if (j+1 < p.length() && p.charAt(j+1) == '*')
            return memo[i][j] = match && helper(s, p, i+1, j, memo) || helper(s, p, i, j+2, memo);
            
        if (match)
            return memo[i][j] = helper(s, p, i+1, j+1, memo);
        return memo[i][j] = false;
    }
}