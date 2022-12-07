class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] vis = new int[m][n];
        
        for (int[] wall: walls) {
            vis[wall[0]][wall[1]] = 1; // Wall represented by 1
        }

        for (int[] guard: guards) {
            vis[guard[0]][guard[1]] = 2; // Guard represented by 2
        }
        
        for (int[] guard: guards) {
            visitInFourDirections(vis, guard, m, n);
        }
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public void visitInFourDirections(int[][] visited, int[] guard, int m, int n) {
        int x = guard[0];
        int y = guard[1];
        // Visting bottom side
        for (int i = x + 1; i < m; i++) {
            if (visited[i][y] == 1 || visited[i][y] == 2) // If a wall or guard is hit
                break;
            visited[i][y] = 3;
        }
        // Visiting right side
        for (int j = y + 1; j < n; j++) {
            if (visited[x][j] == 1 || visited[x][j] == 2) // If a wall or guard is hit
                break;
            visited[x][j] = 3;
        }
        // Visiting top side
        for (int i = x - 1; i >= 0; i--) {
            if (visited[i][y] == 1 || visited[i][y] == 2) // If a wall or guard is hit
                break;
            visited[i][y] = 3;
        }
        // Visiting left side
        for (int j = y - 1; j >= 0; j--) {
            if (visited[x][j] == 1 || visited[x][j] == 2) // If a wall or guard is hit 
                break;
            visited[x][j] = 3;
        }
    }
}