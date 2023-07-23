class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        int[][] dp = new int[n][m];
        dp[0][0] = matrix[0][0];
        addToPq(pq, dp[0][0], k);
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] ^ matrix[0][j];
            addToPq(pq, dp[0][j], k);
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] ^ matrix[i][0];
            addToPq(pq, dp[i][0], k);
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j-1] ^ dp[i-1][j] ^ dp[i][j-1] ^ matrix[i][j];
                addToPq(pq, dp[i][j], k);
            }
        }
        return pq.peek();
    }
    
    public void addToPq(PriorityQueue<Integer> pq, int e, int k) {
        pq.add(e);
        if (pq.size() > k) {
            pq.poll();
        }
    }
}