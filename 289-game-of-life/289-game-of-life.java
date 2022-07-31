class Solution {
    public void gameOfLife(int[][] board) {
        int[][] liveCellMatrix = getLiveCellMatrix(board);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cells = liveCellMatrix[i][j];
                if (cells < 2)
                    board[i][j] = 0;
                if (cells > 3)
                    board[i][j] = 0;
                if (cells == 3)
                    board[i][j] = 1;
            }
        }
    }
    
    private int[][] getLiveCellMatrix(int[][] board) {        
        int[][] res = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                res[i][j] = getLiveCells(i, j, board);
            }
        }
        return res;
    }
    
    private int getLiveCells(int i, int j, int[][] board) {
        int ans = 0;
        int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        for (int k = 0; k < dirs.length; k++) {
            ans += getBoardValue(i + dirs[k][0], j + dirs[k][1], board);
        }
        return ans;
    }
    
    private int getBoardValue(int i, int j, int[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return 0;
        return board[i][j];
    }
}