class Solution {
    public int longestSubstring(String s, int k) {
        int[] freq = new int[26];
        int max = 0, start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        boolean valid = true;
        for (int end = 0; end < s.length(); end++) {
            if (freq[s.charAt(end) - 'a'] < k) {
                String substr = s.substring(start, end);
                max = Math.max(max, longestSubstring(substr, k));
                valid = false;
                start = end + 1;
            }
        }
        return valid ? s.length() : Math.max(max, longestSubstring(s.substring(start), k));
    }
}