class Solution {
    public boolean isSubsequence(String s, String t) {
        return check(s, t, 0, 0);
    }
    
    public boolean check(String s, String t, int j, int i) {
        if (j >= s.length()) // All values were checked equal
            return true;
        for (int k = i; k < t.length(); k++) {
            if (s.charAt(j) == t.charAt(k)) {
                return check(s, t, j+1, k+1);
            }
        }
        return false;
    }
}