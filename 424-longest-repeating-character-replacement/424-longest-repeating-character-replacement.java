class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxf = 0;
        
        int maxWindowSize = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            freq[s.charAt(end) - 'A']++; // Increase the frequency of character
            maxf = Math.max(maxf, freq[s.charAt(end)-'A']); // Calculate the maxFrequency at each step
            // Check if window is valid
            int windowSize = end - start + 1;
            if (windowSize - maxf > k) { // Invalid window -- hence decrease window size by 1
                freq[s.charAt(start) - 'A']--; // Decrease frequency of start character
                start++; // Increment start pointer
                windowSize--; // Decrease window size
            }
            maxWindowSize = Math.max(maxWindowSize, windowSize);
        }
        return maxWindowSize;
    }
}