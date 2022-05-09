class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        
        map.get(stones[0]).add(1);
        
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            HashSet<Integer> jumps = map.get(stone);
            for (int k: jumps) {
                int pos = stone + k;
                if (pos == stones[stones.length - 1])
                    return true;
                if (map.containsKey(pos)) {
                    if (k - 1 > 0)
                        map.get(pos).add(k - 1);
                    map.get(pos).add(k);
                    map.get(pos).add(k + 1);
                }
            }
        }
        return false;
    }
}