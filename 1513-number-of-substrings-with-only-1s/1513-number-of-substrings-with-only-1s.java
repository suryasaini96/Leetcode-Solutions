class Solution {
    public int numSub(String s) {
        int count = 0;
        long MOD = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                long len = 0;
                while (i < s.length() && s.charAt(i) == '1') {
                    len++;
                    i++;
                }
                count += (((len % MOD) * ((len + 1) % MOD)) % MOD)/2;
            }   
        }
        return count;
    }
}