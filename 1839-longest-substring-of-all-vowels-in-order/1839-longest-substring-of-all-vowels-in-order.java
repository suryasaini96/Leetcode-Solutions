class Solution {
    public int longestBeautifulSubstring(String word) {
        if (word.length() < 5) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 1); map.put('e', 2); map.put('i', 3);
        map.put('o', 4); map.put('u', 5);
        int s = 0;
        char c = word.charAt(0);
        HashSet<Character> seen = new HashSet<>();
        seen.add(c);
        int max = Integer.MIN_VALUE;
        for (int k = 1; k < word.length(); k++) {
            if (map.get(c) == map.get(word.charAt(k)) - 1 || map.get(c) == map.get(word.charAt(k))) {
                // If current char is 1 greater than previous char
                // Or current char is equal to previous char
                seen.add(word.charAt(k)); // Add char to seen set
                if (seen.size() == 5) { // All 5 vowels were seen
                    max = Math.max(max, k - s + 1); // Take the window size
                }
            } else { // Reset the window size
                seen.clear();
                seen.add(word.charAt(k)); // Add current char to window and reset the window
                s = k;
            }
            c = word.charAt(k);
        }    
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}