class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i)))
                return s.charAt(i);
            set.add(s.charAt(i));
        }
        return ' ';
    }
}