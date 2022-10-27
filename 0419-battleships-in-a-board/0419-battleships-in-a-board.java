class Solution {
    
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '.')
            return;
        board[i][j] = '.';
        dfs(board, i-1, j, m, n);
        dfs(board, i, j+1, m, n);
        dfs(board, i+1, j, m, n);
        dfs(board, i, j-1, m, n);
    }
}