class Solution {
    
    // 3. Most optimal solution: Using dynamic programming - Bottom up approach
    public int uniquePaths(int m, int n) {
        int table[][] = new int[m][n]; // Create tabulation to store results of sub-problems
        // Number of unique paths for first row and first column is always 1
        for (int i=0; i<m; i++) {
            table[i][0] = 1; // First column
        }
        for (int j=0; j<n; j++) {
            table[0][j] = 1; // First row
        }
        
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                table[i][j] = table[i-1][j] + table[i][j-1];
            }
        }
        return table[m-1][n-1];
    } 
    
    
    // 2. Optimized solution: Using dynamic programming - Top down approach
//     public int uniquePaths(int m, int n) {
//         HashMap<String, Integer> memo = new HashMap<String, Integer>();
//         return uniquePaths(m,n,memo);
//     }
    
//     public int uniquePaths(int m, int n, HashMap<String,Integer> memo) {
//         String point = m + "," + n;
//         if (!memo.containsKey(point)) {
//             if (m == 1 || n == 1) // If there is single row or column - then number of unique ways is 1
//                 memo.put(point, 1);
//             else
//                 memo.put(point, uniquePaths(m-1, n, memo) + uniquePaths(m, n-1, memo));
//         }
//         return memo.get(point);
//     }
    
    // 1. Simple recursive solution: Time complexity - O(2^max(m,n))
    // public int uniquePaths(int m, int n) {
    //     if (m == 1 || n == 1) return 1;
    //     return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    // }
}