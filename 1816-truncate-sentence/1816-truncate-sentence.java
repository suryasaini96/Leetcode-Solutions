class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(words[i]);
        }
        return String.join(" ", list);
    }
}