class Solution {
    
    int count = 0;
    
    public int countSubstrings(String s) {
        if (s.length() == 0 || s == null) 
            return 0;
        for (int i = 0; i < s.length(); i++) {
            extendStrings(s, i, i);
            extendStrings(s, i, i+1);
        }
        return count;
    }
    
    public void extendStrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--; end++;
            count++;
        }       
    }
}