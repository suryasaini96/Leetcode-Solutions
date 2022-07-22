class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int curr = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i+1] - heights[i];
            if (diff > 0) {
                pq.add(diff);
                curr += diff;
            }
            if (curr > bricks) { // Curr is more than bricks
                if (ladders-- == 0) { // Definitely need to use ladder
                    return i;
                }
                curr -= pq.poll();
            }
        }
        return heights.length - 1;
    }
}