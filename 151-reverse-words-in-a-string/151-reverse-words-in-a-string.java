class Solution {
    
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder(); 
        for (int i = words.length-1; i>=0; i--) {
            if (i!=0 && !words[i].isEmpty() )
                sb.append(words[i] + " ");
            else
                sb.append(words[i]); 
        }
        return sb.toString().trim();
    }
    
    // public String reverseWords(String s) {
    //     String[] words = s.split(" ");
    //     List<String> wordsWithoutSpaces = new ArrayList<>();
    //     for (String word: words) {
    //         if (!word.isEmpty())
    //             wordsWithoutSpaces.add(word);
    //     }
    //     Collections.reverse(wordsWithoutSpaces);
    //     return String.join(" ", wordsWithoutSpaces);
    // }
}