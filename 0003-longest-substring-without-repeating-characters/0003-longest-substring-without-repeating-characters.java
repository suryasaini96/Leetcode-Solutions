class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0; 
        else if (s.length() == 1) return 1;
        HashMap<Character, Integer> lastPos = new HashMap<>();
        lastPos.put(s.charAt(0), 0);
        int left = 0, max = 0;
        for (int right = 1; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastPos.containsKey(c) && left <= lastPos.get(c)) {
                // Shift left pointer to the next
                // of last seen character and if left pointer is less than lastPos of char
                left = lastPos.get(c) + 1; 
            }
            int len = right - left + 1;
            lastPos.put(c, right);
            max = Math.max(max, len);
        }
        return max;
    }
}