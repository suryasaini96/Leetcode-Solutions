class Solution {
    public int firstUniqChar(String s) {
        int[] f = new int[26];
        char[] str = s.toCharArray();
        for (char c: str) {
            f[c - 'a']++;
        }
        for (int i = 0; i < str.length; i++) {
            if (f[str[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }
}