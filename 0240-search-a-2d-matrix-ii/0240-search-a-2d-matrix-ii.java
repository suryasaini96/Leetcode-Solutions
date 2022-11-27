class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean binarySearch(int[] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (target == matrix[mid]) {
                return true;
            } else if (matrix[mid] > target) {
                end = mid - 1;
            } else if (matrix[mid] < target) {
                start = mid + 1;
            }
        }
        return false;
    }
}