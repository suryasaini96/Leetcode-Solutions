class Solution {
    
    // 2. Optimized solution: Using dynamic programming - Top down approach
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> memo = new HashMap<String, Integer>();
        return uniquePaths(m,n,memo);
    }
    
    public int uniquePaths(int m, int n, HashMap<String,Integer> memo) {
        String point = m + "," + n;
        if (!memo.containsKey(point)) {
            if (m == 1 || n == 1) // If there is single row or column - then number of unique ways is 1
                memo.put(point, 1);
            else
                memo.put(point, uniquePaths(m-1, n, memo) + uniquePaths(m, n-1, memo));
        }
        return memo.get(point);
    }
    
    // 1. Simple recursive solution: Time complexity - O(2^max(m,n))
    // public int uniquePaths(int m, int n) {
    //     if (m == 1 || n == 1) return 1;
    //     return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    // }
}