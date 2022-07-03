class Solution {
    public List<Integer> partitionLabels(String s) {
        // HashMap to store last index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        
        List<Integer> result = new ArrayList<>();
        // Loop from start till end and partition till the last index
        int lastIndex = 0;
        int firstIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            lastIndex = Math.max(lastIndex, map.get(s.charAt(i)));
            if (i == lastIndex) { // Reached the point where we need to partition all elements from firstIndex to lastIndex
                result.add(lastIndex - firstIndex + 1);
                firstIndex = lastIndex + 1;
            }
        }
        return result;
    }
}