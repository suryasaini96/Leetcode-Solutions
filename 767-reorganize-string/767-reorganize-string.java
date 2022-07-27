class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for (char key: map.keySet()) {
            pq.add(new int[]{key, map.get(key)}); // 0th value - char, 1st value - freq
        }
        
        StringBuilder sb = new StringBuilder();
        char prev = '#';
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (first[0] != prev) {
                prev = (char)first[0];
                sb.append(prev);
                if (--first[1] > 0)
                    pq.add(first);
            } else if (!pq.isEmpty()) {
                int[] second = pq.poll();
                prev = (char)second[0];
                sb.append(prev);
                if (--second[1] > 0)
                    pq.add(second);
                pq.add(first);
            } else {
                return "";
            }
        }
        return sb.toString();
    }
}