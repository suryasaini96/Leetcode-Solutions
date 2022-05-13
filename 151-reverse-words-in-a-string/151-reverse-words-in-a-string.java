class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        List<String> wordsWithoutSpaces = new ArrayList<>();
        for (String word: words) {
            if (!word.isEmpty())
                wordsWithoutSpaces.add(word);
        }
        Collections.reverse(wordsWithoutSpaces);
        return String.join(" ", wordsWithoutSpaces);
    }
}