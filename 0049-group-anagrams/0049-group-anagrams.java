class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String mapKey = String.valueOf(charArray);
            if (!map.containsKey(mapKey)) {
                map.put(mapKey, new ArrayList<>());
            }
            map.get(mapKey).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}