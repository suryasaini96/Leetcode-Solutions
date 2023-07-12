class Solution {
    public int longestContinuousSubstring(String s) {
        char prev = s.charAt(0);
        int len = 1;
        int i = 0, j = 1;
        while (i < j && j < s.length()) {
            char curr = s.charAt(j);
            if (curr == (char)(prev + 1)) {
                len = Math.max(j - i + 1, len);
            } else {
                i = j;   
            }
            prev = curr;
            j++;
        }
        return len;
    }
}