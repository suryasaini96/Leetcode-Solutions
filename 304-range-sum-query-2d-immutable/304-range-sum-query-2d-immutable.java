class NumMatrix {
    
    static int sumRows[][];

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // Pre-computing sums of each row
        sumRows = new int[n+1][m+1];
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=0; j<m; j++) {
                sum+= matrix[i][j];
                sumRows[i+1][j+1] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i=row1; i<=row2; i++) {
            sum+= sumRows[i+1][col2+1] - sumRows[i+1][col1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */