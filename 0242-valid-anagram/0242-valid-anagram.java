class Solution {
    public boolean isAnagram(String s, String t) {
        char[] word1 = new char[26];
        char[] word2 = new char[26];
        
        for (char c : s.toCharArray()) {
            word1[c-'a']++;
        }
        
        for (char c : t.toCharArray()) {
            word2[c-'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (!(word1[i] == word2[i]))
                return false;
        }
        return true;
    }
}