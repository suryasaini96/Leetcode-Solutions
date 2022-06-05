class Solution {
    
    public void solve(char[][] board) {
        int m = board.length; 
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        // Make dfs calls only when both m and n are > 2. Otherwise O will definitely lie on edge
        if (m > 2 && n > 2) {
            // Visit the outer boundaries and for O make dfs call and mark the nodes as visited
            
            // Visiting first row and last row dfs calls
            for (int j = 0; j < n; j++) {
                if (board[0][j] == 'O' && !visited[0][j])
                    dfs(board, 0, j, visited, false);
                if (board[m-1][j] == 'O' && !visited[m-1][j])
                    dfs(board, m-1, j, visited, false);
            }
            
            // Visiting first column and last column dfs calls
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O' && !visited[i][0])
                    dfs(board, i, 0, visited, false);
                if (board[i][n-1] == 'O' && !visited[i][n-1])
                    dfs(board, i, n-1, visited, false);
            }
            
            // Now visit the inner rows and columns
            for (int i = 1; i < m-1; i++) {
                for (int j = 1; j < n-1; j++) {
                    if (board[i][j] == 'O' && !visited[i][j]) {
                        dfs(board, i, j, visited, true);
                    }
                }
            }            
        }
    }
    
    private void dfs(char[][] board, int i, int j, boolean[][] visited, boolean flipCall) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || visited[i][j] || board[i][j] == 'X')
           return;
        
        visited[i][j] = true;
        if (flipCall)
            board[i][j] = 'X'; // Flip O to X
        // Make dfs calls in 4 directions
        dfs(board, i-1, j, visited, flipCall); // top
        dfs(board, i, j+1, visited, flipCall); // right
        dfs(board, i+1, j, visited, flipCall); // bottom
        dfs(board, i, j-1, visited, flipCall); // left
    }
}