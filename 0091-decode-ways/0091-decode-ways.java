class Solution {
    public int numDecodings(String s) {
        Integer[] memo = new Integer[s.length()+1];
        return decode(s, 0, memo);
    }
    
    public int decode(String s, int i, Integer[] memo) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (memo[i] != null) return memo[i];
        int ans = decode(s, i+1, memo); // consider 1 length character
        if (i < s.length() - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7'))
            ans += decode(s, i+2, memo); // consider 2 length characters
        memo[i] = ans;
        return ans;
    }
}