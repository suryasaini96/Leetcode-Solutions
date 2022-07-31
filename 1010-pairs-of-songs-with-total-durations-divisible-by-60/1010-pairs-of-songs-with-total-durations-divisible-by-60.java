class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        for (int i = 0; i < time.length; i++) {
            if (time[i] % 60 == 0) {
                pairs += map.getOrDefault(time[i] % 60, 0);                
            } else if (map.containsKey(60 - time[i] % 60)) {
                pairs += map.get(60 - time[i] % 60);
            }
            map.put(time[i] % 60, map.getOrDefault(time[i] % 60, 0) + 1);
        }
        return pairs;
    }
}