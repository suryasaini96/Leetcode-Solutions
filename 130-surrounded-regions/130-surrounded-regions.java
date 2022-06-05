class Solution {
    //private boolean[][] visited = new boolean[200][200];
    
    public void solve(char[][] board) {
        int m = board.length; 
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        if (m > 2 && n > 2) {
            // Visit the outer boundaries and for O make dfs call and mark the nodes as visited
            
            // Visiting first row and last row dfs calls
            for (int j = 0; j < n; j++) {
                if (board[0][j] == 'O' && !visited[0][j])
                    dfsBoundary(board, 0, j, visited);
                if (board[m-1][j] == 'O' && !visited[m-1][j])
                    dfsBoundary(board, m-1, j, visited);
            }
            
            // Visiting first column and last column dfs calls
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O' && !visited[i][0])
                    dfsBoundary(board, i, 0, visited);
                if (board[i][n-1] == 'O' && !visited[i][n-1])
                    dfsBoundary(board, i, n-1, visited);
            }
            
            // Now visit the inner rows and columns
            for (int i = 1; i < m-1; i++) {
                for (int j = 1; j < n-1; j++) {
                    if (board[i][j] == 'O') {
                        dfsInner(board, i, j, visited);
                    }
                }
            }            
        }
    }
    
    private void dfsBoundary(char[][] board, int i, int j, boolean[][] visited) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || visited[i][j] || board[i][j] == 'X')
           return;
        
        visited[i][j] = true;
        // Make dfs calls in 4 directions
        dfsBoundary(board, i-1, j, visited); // top
        dfsBoundary(board, i, j+1, visited); // right
        dfsBoundary(board, i+1, j, visited); // bottom
        dfsBoundary(board, i, j-1, visited); // left
    }
    
    private void dfsInner(char[][] board, int i, int j, boolean[][] visited) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || visited[i][j] || board[i][j] == 'X')
           return;
        visited[i][j] = true;
        board[i][j] = 'X'; // Flip O to X
        // Make dfs calls in 4 direction
        dfsInner(board, i-1, j, visited); // top
        dfsInner(board, i, j+1, visited); // right
        dfsInner(board, i+1, j, visited); // bottom
        dfsInner(board, i, j-1, visited); // left   
    }
}