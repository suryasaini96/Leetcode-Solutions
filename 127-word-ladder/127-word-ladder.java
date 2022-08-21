class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int steps = 1;
        q.offer(beginWord);
        set.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) return steps;
                for (int j = 0; j < word.length(); j++) {
                    char[] wordArr = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[j] = c;
                        String str = new String(wordArr);
                        if (set.contains(str) && !visited.contains(str)) {
                            q.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}