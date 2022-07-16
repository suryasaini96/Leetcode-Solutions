class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // Finding the frequency of each element and storing in map
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int unique_pairs = 0;
        for (int key: map.keySet()) {
            if (k > 0 && map.containsKey(key + k) || k == 0 && map.get(key) > 1) {
                unique_pairs++;
            }
        }
        return unique_pairs;
    }
}