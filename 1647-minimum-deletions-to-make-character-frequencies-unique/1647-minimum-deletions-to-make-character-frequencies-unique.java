class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        HashSet<Integer> reduced = new HashSet<>();
        int deletions = 0;
        for (int i = 0; i < 26; i++) {
            while (freq[i] != 0 && reduced.contains(freq[i])) {
                freq[i]--;
                deletions++;
            }
            reduced.add(freq[i]);
        }
        return deletions;
    }
}