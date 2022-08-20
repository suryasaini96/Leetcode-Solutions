class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n*n + 1];
        q.offer(1);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == n*n) return steps;
                for (int k = 1; k <= 6; k++) {
                    if (curr + k > n*n) break;
                    int next = curr + k;
                    int[] nextPos = getPos(board, next);
                    if (board[nextPos[0]][nextPos[1]] > 0) { // It's a snake or ladder so go there
                        next = board[nextPos[0]][nextPos[1]];
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private int[] getPos(int[][] board, int num) {
        int n = board.length;
        int i = (num - 1)/n;
        int j = (num - 1)%n;
        int row = n - i - 1;
        int col = i % 2 == 0 ? j : n - j - 1;
        return new int[]{row, col};
    }
}