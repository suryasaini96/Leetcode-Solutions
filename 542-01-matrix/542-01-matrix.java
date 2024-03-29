class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int INF = m + n; // distance is upto m + n
        // Top and left for each cell starting from top left corner
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;
                int top = INF, left = INF;
                if (i - 1 >= 0)
                    top = mat[i-1][j];
                if (j - 1 >= 0)
                    left = mat[i][j-1];
                mat[i][j] = Math.min(top, left) + 1;
            }
        }
        
        // Right and down for each cell starting from bottom left corner
        for (int i = m-1; i>=0; i--) {
            for (int j = n-1; j>=0; j--) {
                if (mat[i][j] == 0) continue;
                int right = INF, down = INF;
                if (j + 1 < n)
                    right = mat[i][j+1];
                if (i + 1 < m)
                    down = mat[i+1][j];
                int val = Math.min(right, down) + 1;
                mat[i][j] = Math.min(mat[i][j], val);
            }
        }
        return mat;
    }
}