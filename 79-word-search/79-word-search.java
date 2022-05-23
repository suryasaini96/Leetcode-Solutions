class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(word, 0, i, j, board, new boolean[board.length][board[0].length]))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(String word, int pos, int i, int j, char[][] board, boolean visited[][]) {
        if (pos >= word.length())
            return true;
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j])
            return false;
            
        if (board[i][j] == word.charAt(pos)) {
            visited[i][j] = true;
            boolean result = dfs(word, pos+1, i-1, j, board, visited) || dfs(word, pos+1, i, j+1, board, visited) 
                || dfs(word, pos+1, i+1, j, board, visited) || dfs(word, pos+1, i, j-1, board, visited);
            if (!result) // If we don't find a result from dfs then mark the character as unvisited and return false (backtrack)
                return visited[i][j] = false;
            else
                return true;
        } else
            return visited[i][j] = false;
            
    }
}