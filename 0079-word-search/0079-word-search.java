class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, String word, int k, boolean[][] vis) {
        if (k >= word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j])
            return false;
        if (word.charAt(k) != board[i][j])
            return false;
        boolean wordExist = false;
        if (word.charAt(k) == board[i][j]) {
            vis[i][j] = true;
            wordExist = dfs(board, i-1, j, word, k + 1, vis) || dfs(board, i, j+1, word, k + 1, vis) 
                || dfs(board, i+1, j, word, k + 1, vis) || dfs(board, i, j-1, word, k + 1, vis);
            vis[i][j] = false;
        }
        return wordExist;
    }
}