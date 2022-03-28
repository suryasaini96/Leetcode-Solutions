class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        
        // Flip around the first diagonal
        for (int i=0; i<N; i++){
            for (int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Flip around the middle column vertically
        for (int i=0; i<N; i++){
            for (int j=0; j<N/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N-1-j];
                matrix[i][N-1-j] = temp;
            }
        }
    }
}