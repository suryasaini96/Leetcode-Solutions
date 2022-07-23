class Solution {
    public int minDeletions(String s) {
        // Freq vs list of chars
        TreeMap<Integer, List<Character>> map = new TreeMap<>(Collections.reverseOrder());
        int deletions = 0;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;   
        }
        
        for (int i = 0; i < 26; i++) {
            int count = freq[i];
            char c = (char)(i + 'a');
            if (map.containsKey(count)) {
                List<Character> list = map.get(count);
                list.add(c);
                map.put(count, list);
            } else if (count != 0) {
                map.put(count, new ArrayList<Character>(Arrays.asList(c)));
            }
        }
        
        Set<Integer> reduced = new HashSet<>();
        for (Map.Entry<Integer, List<Character>> entry: map.entrySet()) {
            List<Character> charList = entry.getValue();
            while (charList.size() > 1) {
                char c = charList.get(0);
                int f = freq[c - 'a'];
                while (map.containsKey(f) || reduced.contains(f)) {
                    freq[c - 'a'] = --f;
                    deletions++;
                }
                freq[c-'a'] = f;
                if (f != 0) reduced.add(f);
                charList.remove(0);
            }
        } 
        return deletions;
    }
}