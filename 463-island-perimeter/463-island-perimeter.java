class Solution {
    private static final int[][] dir = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += checkFourDirections(i, j, grid);
                }
            }
        }
        return perimeter;
    }
    
    private int checkFourDirections(int i, int j, int[][] grid) {
        int length = 0;
        for (int k = 0; k < dir.length; k++) {
            int x = dir[k][0] + i;
            int y = dir[k][1] + j;
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                if (grid[x][y] == 0) {
                    length++;
                }
            } else {
                length++;
            }
        }
        return length;
    }
}