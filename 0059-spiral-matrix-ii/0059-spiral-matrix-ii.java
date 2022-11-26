class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int num = 1;
        
        int rowStart = 0, rowEnd = n-1, colStart = 0, colEnd = n-1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                mat[rowStart][j] = num++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                mat[i][colEnd] = num++;
            }
            colEnd--;
            for (int j = colEnd; j >= colStart; j--) {
                if (rowStart <= rowEnd)
                    mat[rowEnd][j] = num++;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                if (colStart <= colEnd) {
                    mat[i][colStart] = num++;
                }
            }
            colStart++;
        }
        return mat;
    }
}