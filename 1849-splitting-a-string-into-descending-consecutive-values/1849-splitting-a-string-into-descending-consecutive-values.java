class Solution {
    public boolean splitString(String s) {
        return backtrack(s, null);
    }
    
    public boolean backtrack(String s, Long prev) {
        long curr = 0;
        for (int i = 0; i < s.length(); i++) {
            curr = curr * 10 + s.charAt(i) - '0';
            if (prev == null) {
                prev = curr;
                if (backtrack(s.substring(i+1), prev)) return true;
                prev = null; // backtrack
            } else if (curr == prev - 1) {
                if (i == s.length() - 1) return true;
                prev = curr;
                if (backtrack(s.substring(i+1), prev))
                    return true;
                prev = curr + 1; // backtrack
            }
        }
        return false;
    }
}