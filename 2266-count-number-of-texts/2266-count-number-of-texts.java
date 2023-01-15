class Solution {
    
    private static final int mod = 1000000007;
    
    public int countTexts(String pressedKeys) {
        int[] keys = new int[]{0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        Integer[] dp = new Integer[pressedKeys.length()];
        return decode(pressedKeys, 0, dp, keys);
    }
    
    public int decode(String s, int idx, Integer[] dp, int[] keys) {
        if (idx == s.length()) return 1;
        if (dp[idx] != null) return dp[idx];
        int count = 0;
        int num = s.charAt(idx) - '0';
        int ways = keys[num];
        for (int i = 0; i < ways && idx + i < s.length() && s.charAt(idx) == s.charAt(idx + i); i++) {
            count += decode(s, idx + i + 1, dp, keys);
            count %= mod;
        }
        return dp[idx] = count;
    }
}