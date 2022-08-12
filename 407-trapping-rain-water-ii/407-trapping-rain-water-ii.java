class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue((a,b) -> {
            Pair x = (Pair) a;
            Pair y = (Pair) b;
            return Integer.compare(x.height, y.height);
        });
        boolean visited[][] = new boolean[m][n];
        int water = 0;
        int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        
        // Add all the boundary cells to the pq
        // Mark the cells visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                    pq.add(new Pair(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        
        // From the boundary cell move inwards from smallest height because water could leak from there
        // Delegate the max height from both to that cell
        // Mark the cells visited
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            for (int[] dir: dirs) {
                int new_row = pair.row + dir[0];
                int new_col = pair.col + dir[1];
                if (new_row >= 0 && new_row < m && new_col >= 0 && new_col < n 
                    && !visited[new_row][new_col]) {
                    
                    int new_height = heightMap[new_row][new_col];
                    water += Math.max(0, pair.height - new_height);
                    
                    int delegated_height = Math.max(new_height, pair.height);
                    pq.add(new Pair(new_row, new_col, delegated_height));
                    visited[new_row][new_col] = true;
                }
                
            }
        }
        return water;
    }
}

class Pair {
    int row;
    int col;
    int height;
    
    Pair(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}