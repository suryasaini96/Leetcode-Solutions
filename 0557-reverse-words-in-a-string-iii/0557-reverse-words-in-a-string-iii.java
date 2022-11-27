class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            res.add(sb.toString());
        }
        return String.join(" ", res); 
    }
}