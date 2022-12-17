class Solution {
    
    private static Set<Character> vowels = new HashSet<>();
    
    static {
        vowels.add('a'); vowels.add('e'); vowels.add('i');
        vowels.add('o'); vowels.add('u');
    }
    
    public int maxVowels(String s, int k) {
        Deque<Character> q = new LinkedList<Character>();
        int j = 0, vowelCount = 0, maxCount = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (q.size() < k) {
                if (vowels.contains(c)) {
                    vowelCount++;
                }
                q.add(c);
            } else { // When q size is equal to k
                char firstChar = q.pollFirst();
                if (vowels.contains(firstChar)) {
                    vowelCount--;
                }
                if (vowels.contains(c)) {
                    vowelCount++;
                }
                q.add(c);
            }
            maxCount = Math.max(maxCount, vowelCount);
            j++;
        }
        return maxCount;
    }
}