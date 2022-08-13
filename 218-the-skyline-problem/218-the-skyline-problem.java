class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.add(0);
        int pMax = 0;
        
        for (int[] h: heights) {
            if (h[1] < 0) { // It's the start
                pq.add(-h[1]);
            } else { // It's the end so remove
                pq.remove(h[1]);
            }
            
            int currMax = pq.peek();
            if (currMax != pMax) { // It's the critical point
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(h[0]);
                temp.add(currMax);
                res.add(temp);
                pMax = currMax;
            }
        }
        return res;
    }
}