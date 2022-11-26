class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!hashSet.add(board[i][j] + " in row -" + i) ||
                        !hashSet.add(board[i][j] + " in col -" + j) ||
                        !hashSet.add(board[i][j] + " in block -" + i/3 + " and " + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}