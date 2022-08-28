class Solution {    
    
    private static final int MOD = 1000000007;
    
    public int countVowelPermutation(int n) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('s', Arrays.asList('a','e','i','o','u'));
        map.put('a', Arrays.asList('e'));
        map.put('e', Arrays.asList('a', 'i'));
        map.put('i', Arrays.asList('a','e','o','u'));
        map.put('o', Arrays.asList('i','u'));
        map.put('u', Arrays.asList('a'));
        int[][] dp = new int[26][n+1];
        return permutations('s', n, map, dp);
    }
    
    private int permutations(char prev, int n, HashMap<Character, List<Character>> map, int[][] dp) {
        if (n == 0) return 1;
        if (dp[prev-'a'][n] > 0) return dp[prev-'a'][n];
        
        for (char c: map.get(prev)) {
            dp[prev-'a'][n] = (dp[prev-'a'][n] + permutations(c, n-1, map, dp)) % MOD;
        }
        return dp[prev-'a'][n];
    } 
}