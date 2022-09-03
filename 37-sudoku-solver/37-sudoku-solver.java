class Solution {
    public void solveSudoku(char[][] board) {
        HashMap<String, HashSet<Integer>> map = new HashMap<>();
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    int digit = board[i][j] - '0';
                    addDigit(digit, i, j, map, row, col);   
                }
            }
        }
        solve(board, map, row, col);
    }
    
    public boolean solve(char[][] board, HashMap<String, HashSet<Integer>> map, int[][] row, int[][] col) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        if (isPossible(k, board, i, j, map, row, col)) {
                            board[i][j] = (char)(k + '0');
                            addDigit(k, i, j, map, row, col);
                            if (solve(board, map, row, col)) {
                                return true;
                            } else {
                                removeDigit(k, i, j, map, row, col, board);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isPossible(int val, char[][] board, int i, int j, HashMap<String, HashSet<Integer>> map, int[][] row, int[][] col) {
        String boxIndex = String.valueOf(i/3) + String.valueOf(j/3);
        HashSet<Integer> set = map.get(boxIndex);
        if (set != null && set.contains(val))
            return false;
        if (row[i][val] == 1)
            return false;
        if (col[j][val] == 1)
            return false;
        return true;
    }
    
    private void addDigit(int digit, int i, int j, HashMap<String, HashSet<Integer>> map, int[][] row, int[][] col) {
        String boxIndex = String.valueOf(i/3) + String.valueOf(j/3);
        if (map.containsKey(boxIndex)) {
            HashSet<Integer> set = map.get(boxIndex);
            set.add(digit);
            map.put(boxIndex, set);
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(digit);
            map.put(boxIndex, set);
        }
        row[i][digit] = 1;
        col[j][digit] = 1;    
    }
    
    private void removeDigit(int digit, int i, int j, HashMap<String, HashSet<Integer>> map, int[][] row, int[][] col, char[][] board) {
        String boxIndex = String.valueOf(i/3) + String.valueOf(j/3);
        if (map.containsKey(boxIndex)) {
            HashSet<Integer> set = map.get(boxIndex);
            set.remove(digit);
            map.put(boxIndex, set);
        }
        row[i][digit] = 0;
        col[j][digit] = 0;
        board[i][j] = '.';
    }

}
