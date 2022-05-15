class Solution {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
    
//     public String reverseWords(String s) {
//         List<String> words = new ArrayList<>();
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i<s.length(); i++) {
//             if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i)))
//                 sb.append(s.charAt(i)); 
//             else {
//                 if (sb.length()>0)
//                     words.add(sb.toString());
//                 sb.setLength(0);
//             }
//         }
//         if (sb.length()>0)
//             words.add(sb.toString());
//         Collections.reverse(words);
//         return String.join(" ", words);  
//     }
    
    
    // public String reverseWords(String s) {
    //     String[] words = s.split(" ");
    //     StringBuilder sb = new StringBuilder(); 
    //     for (int i = words.length-1; i>=0; i--) {
    //         if (i!=0 && !words[i].isEmpty() )
    //             sb.append(words[i] + " ");
    //         else
    //             sb.append(words[i]); 
    //     }
    //     return sb.toString().trim();
    // }
    
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
    
    // public String reverseWords(String s) {
    //     String[] words = s.split(" ");
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = words.length-1; i>=0; i--) {
    //         if (!words[i].isEmpty())
    //             sb.append(words[i] + " ");
    //     }
    //     return sb.toString().trim();
    // }

}