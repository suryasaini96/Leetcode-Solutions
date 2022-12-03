class Solution {
    
    int x = -1, y = -1;
    
    public int[][] findFarmland(int[][] land) {  
       List<int[]> list = new ArrayList<>();
       for (int i = 0; i < land.length; i++) {
           for (int j = 0; j < land[0].length; j++) {
               if (land[i][j] == 1 && corner(land, i, j)) {
                   dfs(land, i, j);
                   int[] corner = new int[]{i, j, x, y};
                   list.add(corner);
                   reset();
               }
           }
       }
       int res[][] = new int[list.size()][4];
       int k = 0;
       for (int[] ele : list) {
           res[k++] = ele;
       }
       return res; 
    }
    
    private void dfs(int[][] land, int r, int c) {
        if (r < 0 || r >= land.length || c < 0 || c >= land[0].length ||
           land[r][c] == 0) {
            return;
        }
        x = Math.max(x, r);
        y = Math.max(y, c);
        land[r][c] = 0;
        dfs(land, r+1, c); // bottom
        dfs(land, r, c+1); // right
        dfs(land, r-1, c); // top
        dfs(land, r, c-1); // left
    }
    
    private void reset() {
        x = -1;
        y = -1;
    }
    
    private boolean corner(int[][] land, int r, int c) {
        if (r < 0 || r >= land.length || c < 0 || c >= land[0].length ||
           land[r][c] == 0) {
           return false;
        }
        int top = getVal(land, r-1, c);
        int left = getVal(land, r, c-1);
        if (top == 0 && left == 0 && land[r][c] == 1)
            return true;
        return false; 
    }
    
    private int getVal(int[][] land, int r, int c) {
        if (r < 0 || r >= land.length || c < 0 || c >= land[0].length) {
            return 0;
        }
        return land[r][c];
    }
}