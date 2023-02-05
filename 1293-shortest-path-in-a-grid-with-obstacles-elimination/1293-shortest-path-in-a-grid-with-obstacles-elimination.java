class Solution {
    public int shortestPath(int[][] grid, int k) {
        Integer[][] vis = new Integer[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0, 0, 0, k}); // x, y, current path length, number of obstacles we can still remove
        while (!q.isEmpty()) {
            int[] v = q.poll();
            int x = v[0], y = v[1];
            
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
                continue;
            
            if (x == grid.length-1 && y == grid[0].length-1)
                return v[2];
            
            if (grid[x][y] == 1) {
                if (v[3] > 0) { // The number of obstacles we can still remove
                    v[3]--;
                } else {
                    continue;
                }
            }
            
            if (vis[x][y] != null && vis[x][y] >= v[3]) // We can visit the current node from previous path using less obstacles
                continue;
            vis[x][y] = v[3];
            
            q.add(new int[]{x+1,y,v[2]+1,v[3]});
            q.add(new int[]{x,y+1,v[2]+1,v[3]});
            q.add(new int[]{x-1,y,v[2]+1,v[3]});
            q.add(new int[]{x,y-1,v[2]+1,v[3]});
        }
        return -1;
    }
}