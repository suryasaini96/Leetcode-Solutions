class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<List<Integer>> visited = new HashSet<>();
        for (int i: forbidden) {
            visited.add(Arrays.asList(i, 1)); // Add forbidden numbers to visited matrix in fwd and back dir
            visited.add(Arrays.asList(i, 0));
        }
        int level = 0;
        Queue<int[]> q = new LinkedList<>(); // 0 -- value , 1 -- direction
        q.add(new int[]{0, 1});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] e = q.poll();
                int val = e[0];
                int dir = e[1];
                List<Integer> num = Arrays.asList(val, dir);
                if (!visited.contains(num) && val <= 6000) { // value upper bound
                    visited.add(num);
                    if (val == x) return level;
                    if (val + a > 0 && !visited.contains(Arrays.asList(val + a, 1)))
                        q.add(new int[]{val + a, 1}); // visited val + a in forward direction
                    // visit val - b in backward direction only when current direction is 1 (forward) i.e can't visit backward twice 
                    if (val - b > 0 && !visited.contains(Arrays.asList(val - b, 0)) && dir != 0) 
                        q.add(new int[]{val - b, 0}); 
                }
            }
            level++;
        }
        return -1;
    }
}