class Solution {
    public List<List<String>> solveNQueens(int n) {
        String dots = ".".repeat(n);
        List<List<String>> result = new ArrayList<>();
        List<StringBuilder> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            board.add(i, new StringBuilder(dots));
        }
        solve(result, board, 0, n);
        return result;
    }
    
    private void solve(List<List<String>> result, List<StringBuilder> board, int col, int n) {
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (StringBuilder sb: board) {
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }
        
        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board.get(row).setCharAt(col, 'Q');
                solve(result, board, col+1, n);
                board.get(row).setCharAt(col, '.');
            }
        }
    }
    
    private boolean isSafe(List<StringBuilder> board, int row, int col, int n) {
        int cr = row;
        int cc = col;
        
        // Check the left of current {row,col} if queen could be placed
        while (col>=0) {
            if (board.get(row).charAt(col) == 'Q')
                return false;
            col--;
        }
        
        // Check the top left diagonal if queen could be placed
        col = cc;
        while (row>=0 && col>=0) {
            if (board.get(row).charAt(col) == 'Q')
                return false;
            row--;
            col--;
        }
        
        // Check the bottm left diagonal if queen could be placed
        row = cr;
        col = cc;
        while (row<n && col>=0) {
            if (board.get(row).charAt(col) == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }
}