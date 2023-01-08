class Solution {
    public int deleteGreatestValue(int[][] grid) {
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < grid[0].length; j++) {
                pq.add(grid[i][j]);
            }
            list.add(pq);
        }
        
        int result = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (PriorityQueue<Integer> pq : list) {
                Integer value = pq.poll();
                max = Math.max(max, value); 
            }
            result += max;
        }
        return result;
    }
}