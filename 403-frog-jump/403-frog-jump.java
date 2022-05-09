class Solution {
    // Using HashMap and HashSet to store k at each position
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
    
//     // Using DFS
//     public boolean canCross(int[] stones) {
//         int n = stones.length;
//         if (stones[1] != 1) return false;
//         if (n == 2) return true;
//         int lastStone = stones[n - 1];
//         HashSet<Integer> set = new HashSet<>();
//         for (int i = 0; i < stones.length; i++) {
//             if (i > 3  && stones[i] > stones[i-1] * 2) return false;
//             set.add(stones[i]);
//         }
//         return canReach(set, lastStone, 1, 1);
//     }
    
//     private boolean canReach(HashSet<Integer> stones, int lastStone, int curr, int k) {
//         if (curr + k - 1 == lastStone || curr + k == lastStone || curr + k + 1 == lastStone) {
//             return true;
//         }
//         if (k > 1 && stones.contains(curr + k - 1))
//             if (canReach(stones, lastStone, curr + k - 1, k - 1)) return true;
//         if (stones.contains(curr + k))
//             if (canReach(stones, lastStone, curr + k, k)) return true;
//         if (stones.contains(curr + k + 1))
//             if (canReach(stones, lastStone, curr + k + 1, k + 1)) return true;
//         return false;
//     }
}