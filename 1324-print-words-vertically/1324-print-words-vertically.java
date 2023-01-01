class Solution {
    public List<String> printVertically(String s) {
        int maxLen = -1;
        List<String> result = new ArrayList<>(); 
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            maxLen = Math.max(maxLen, words[i].length());
        }
        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (String word: words) {
                char c = i < word.length() ? word.charAt(i) : ' ';
                sb.append(c);
            }
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length()-1);
            }
            result.add(sb.toString());
        }
        return result;
    }
}