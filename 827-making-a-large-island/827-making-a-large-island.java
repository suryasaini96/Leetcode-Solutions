class Solution {
    public int largestIsland(int[][] grid) {
        HashMap<Integer, Integer> map = new HashMap<>(); // map of count vs size
        map.put(0, 0); // 0 count as 0 area
        int count = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    move(grid, i, j, map, count);
                    count++;
                }        
            }
        }
        
        int max = map.getOrDefault(2, 0); // Get first island size as max
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighbours = getNeighbours(grid, i, j);
                    int area = 1;
                    for (int neighbour: neighbours) {
                        area += map.get(neighbour);
                    }
                    if (area > max)
                        max = area;
                }        
            }
        }
        return max;
    }
    

    private void move(int[][] grid, int i, int j, HashMap<Integer, Integer> map, int count) {
        if (!isValid(grid, i, j) || grid[i][j] == 0 || grid[i][j] > 1)
            return;
        grid[i][j] = count;
        map.put(count, map.getOrDefault(count, 0) + 1);
        
        move(grid, i+1, j, map, count); // down
        move(grid, i, j+1, map, count); // right
        move(grid, i-1, j, map, count); // top
        move(grid, i, j-1, map, count); // left
    }
    
    private HashSet<Integer> getNeighbours(int[][] grid, int i, int j) {
        HashSet<Integer> set = new HashSet<>();
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; 
        for (int k = 0; k < dirs.length; k++) {
            int new_i = dirs[k][0] + i;
            int new_j = dirs[k][1] + j;
            if (isValid(grid, new_i, new_j))
                set.add(grid[new_i][new_j]);
        }
        return set;
    }
    
    private boolean isValid(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return false;
        return true;
    }
}