class Solution {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> memo = new HashMap<>();
        HashSet<String> words = new HashSet<>(wordDict);
        return wordsBroken(s, 0, words, memo);
    }
    
     private List<String> wordsBroken(String s, int i, HashSet<String> wordDict, HashMap<Integer, List<String>> memo) {
        if (memo.containsKey(i)) return memo.get(i);
        List<String> sentences = new ArrayList<>();
        if (i >= s.length()) 
            sentences.add("");    
        for (int j=i; j<s.length(); j++) {
            String word = s.substring(i,j+1);
            if (wordDict.contains(word)) {
                List<String> brokenSentences = wordsBroken(s, j+1, wordDict, memo);
                for (String brokenSentence: brokenSentences) {
                    if (brokenSentence.isEmpty())
                        sentences.add(word);
                    else
                        sentences.add(word + " " + brokenSentence);
                }
            }
        }
        memo.put(i, sentences);
        return sentences;
    }
}