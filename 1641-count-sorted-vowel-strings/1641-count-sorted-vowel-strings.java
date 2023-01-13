class Solution {
    
    int count = 0;
    
    public int countVowelStrings(int n) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        backtrack(vowels, n, 0, "");
        return count;
    }
    
    public void backtrack(List<Character> vowels, int n, int pos, String str) {
        if (str.length() == n) {
            count++;
            return;
        }
        for (int i = pos; i < vowels.size(); i++) {
            backtrack(vowels, n, i, str + vowels.get(i));
        }
    }
}