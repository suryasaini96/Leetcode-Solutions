class Solution {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        Arrays.sort(words, (a, b) -> {
            return Integer.compare(a.length(), b.length());
        });
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            if (i == 0) {
                char c = sb.charAt(0);
                sb.setCharAt(0, Character.toUpperCase(c));
            } else {
                char c = sb.charAt(0);
                sb.setCharAt(0, Character.toLowerCase(c));
            }
            words[i] = sb.toString();
        }
        return String.join(" ", words);
    }
}