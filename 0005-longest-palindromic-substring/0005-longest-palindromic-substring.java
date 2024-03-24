class Solution {
    
    int max = Integer.MIN_VALUE;
    int starting_point = -1;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int start = 0; start < len - 1; start++) {
            findLongest(s, start, start);
            findLongest(s, start, start + 1);
        }
        return s.substring(starting_point, starting_point + max);
    }
    
    public void findLongest(String str, int s, int e) {
        while (s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)) {
            s--; e++;
        }
        if (e - s - 1 > max) {
            max = e - s - 1;
            starting_point = s + 1;
        }
    }
}