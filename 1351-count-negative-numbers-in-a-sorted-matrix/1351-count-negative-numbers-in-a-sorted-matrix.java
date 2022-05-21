class Solution {
    
    // O(m+n) solution
    public int countNegatives(int[][] grid) {
        int loopStart = grid[0].length-1;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = loopStart; j>=-1; j--) {
                if (j == -1 || grid[i][j] >= 0) {
                    count += grid[0].length - j - 1;
                    loopStart = j;
                    break;
                }
            }
        }
        return count;
    }
    
//     // Approach 1: Using binary search
//     public int countNegatives(int[][] grid) {
//         int sum = 0;
//         for (int i = 0; i < grid.length; i ++) {
//             int pivot = firstNegative(grid[i], 0, grid[i].length-1);
//             if (pivot == -1)
//                 sum += 0;
//             else
//                 sum += grid[i].length - pivot;
//         }
//         return sum;
//     }
    
//     private int firstNegative(int[] nums, int left, int right) {
//         int pivot = -1;
//         while (left <= right) {
//             int mid = left + (right - left)/2;
//             if (nums[mid] < 0)
//                 right = mid;
//             else
//                 left = mid+1;
//             if (left == right && nums[right] < 0) {
//                 pivot = right;
//                 break;
//             }
//         }
//         return pivot;
//     }
}