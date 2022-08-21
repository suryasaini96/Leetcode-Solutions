class Solution {
    
    static int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        PriorityQueue<int[]> heights = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    heights.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        
        int[] start = new int[]{0,0};
        int ans = 0;
        while (!heights.isEmpty()) {
            int[] next = heights.poll();
            int steps = getMinSteps(forest, start, next, m, n);
            if (steps < 0) 
                return -1;
            ans += steps;
            start[0] = next[0];
            start[1] = next[1];
        }
        return ans;
    }
    
    private int getMinSteps(List<List<Integer>> forest, int[] start, int[] end, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        q.add(start);
        vis[start[0]][start[1]] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] == end[0] && curr[1] == end[1])
                    return steps;
                for (int k = 0; k < dirs.length; k++) {
                    int r = curr[0] + dirs[k][0];
                    int c = curr[1] + dirs[k][1];
                    if (r < 0 || r >= m || c < 0 || c >= n || forest.get(r).get(c) == 0 || vis[r][c])
                        continue;
                    q.add(new int[]{r, c});
                    vis[r][c] = true;
                }
            }
            steps++;
        }
        return -1;
    }
}