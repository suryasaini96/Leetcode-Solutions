class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int minutes = 0;
        Queue<Integer> queue = new LinkedList<>();
        int fresh_count = 0;
        // Add all the rotten oranges in the queue and keep count of fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i*m + j); // Using the hash: x*m + j to identify a pair {x,y}
                } else if (grid[i][j] == 1) {
                    fresh_count++;
                }
            }
        }
        
        // Base case: if count of fresh oranges is zero
        if (fresh_count == 0) return 0;
        
        int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        // Now start rotting all the oranges to the neighbours of each rotten orange
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int code = queue.poll();
                int x = code/m; // Get the x value
                int y = code%m; // Get the y value
                for (int k = 0; k < dirs.length; k++) {
                    int new_x = x + dirs[k][0];
                    int new_y = y + dirs[k][1];   
                    if (new_x < 0 || new_x >= n || new_y < 0 || new_y >= m || grid[new_x][new_y] == 0 || grid[new_x][new_y] == 2) 
                        continue;
                    grid[new_x][new_y] = 2; // Mark the orange as rotten
                    queue.add(new_x*m + new_y); // Add the new rotten orange to the queue
                    fresh_count--; // decrement the fresh count
                }
            }
        }
        return fresh_count == 0 ? minutes-1 : -1;
    }
    
}