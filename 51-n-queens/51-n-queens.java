class Solution {
    public List<List<String>> solveNQueens(int n) {
        String dots = ".".repeat(n);
        List<List<String>> result = new ArrayList<>();
        List<StringBuilder> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            board.add(i, new StringBuilder(dots));
        }
        int[] top_left_diagonal = new int[2*n-1];
        int[] bottom_left_diagonal = new int[2*n-1];
        int[] left_row = new int[n];
        solve(result, board, 0, n, top_left_diagonal, bottom_left_diagonal, left_row);
        return result;
    }
    
    private void solve(List<List<String>> result, List<StringBuilder> board, int col, int n, int[] top_left_diagonal, int[] bottom_left_diagonal, int[] left_row) {
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (StringBuilder sb: board) {
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }
        
        for (int row = 0; row < n; row++) {
            if (bottom_left_diagonal[row + col] == 0 
                && top_left_diagonal[n-1 + col-row] == 0 && left_row[row] == 0) {
                board.get(row).setCharAt(col, 'Q');
                setHash(top_left_diagonal, bottom_left_diagonal, left_row, row, col, n, 1);
                solve(result, board, col+1, n, top_left_diagonal, bottom_left_diagonal, left_row);
                board.get(row).setCharAt(col, '.');
                setHash(top_left_diagonal, bottom_left_diagonal, left_row, row, col, n, 0);
            }
        }
    }
    
    private void setHash(int[] top_left_diagonal, int[] bottom_left_diagonal, int[] left_row, int row, int col, int n, int val) {
        top_left_diagonal[n-1 + col-row] = val;
        bottom_left_diagonal[row + col] = val;
        left_row[row] = val;
    }
}