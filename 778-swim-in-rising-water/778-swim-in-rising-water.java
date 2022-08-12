class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        pq.add(new int[]{0, 0});
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        visited[0][0] = true;
        int ans = -1;
        int dirs[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        while (!pq.isEmpty()) {
            int[] e = pq.poll();
            ans = Math.max(ans, grid[e[0]][e[1]]);
            if (e[0] == m-1 && e[1] == n-1)
                break;
            for (int[] dir: dirs) {
                int x = dir[0] + e[0];
                int y = dir[1] + e[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                visited[x][y] = true;
                pq.add(new int[]{x,y});
            }
        }
        return ans;
    }
}