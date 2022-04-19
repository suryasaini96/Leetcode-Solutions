class Solution {
    
    
    public boolean isMatch(String s, String p) {
        Boolean memo[][] = new Boolean[s.length()+1][p.length()+1]; 
        return helper(s, p, 0, 0, memo);
    }
    
    // Top-down memoized approach
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
            // If characters match then check next character in s else skip the character in p (along with *) 
            return memo[i][j] = match && helper(s, p, i+1, j, memo) || helper(s, p, i, j+2, memo);
            
        if (match)
            return memo[i][j] = helper(s, p, i+1, j+1, memo); // If both i and j match then check next characters of both
        return memo[i][j] = false; // Else characters don't match
    }
}