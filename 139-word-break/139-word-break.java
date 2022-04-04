class Solution {
    
    // Memoized recursive solution 
    
    Boolean memo[];
    
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        return wordBreak(0,s,new HashSet(wordDict));            
    }
    
    private boolean wordBreak(int i, String s, HashSet<String> wordDict) {
        if (i == s.length()) return true;
        if (memo[i]!=null) return memo[i];
        for (int j=i+1; j<=s.length(); j++) {
            String word = s.substring(i,j);
            if (wordDict.contains(word) && wordBreak(j,s,wordDict))
                return memo[i]=true;
        }
        return memo[i]=false;
    }
}