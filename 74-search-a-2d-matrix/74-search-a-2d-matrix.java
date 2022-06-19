class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0])
                row = i;
        }
        return binarySearch(matrix[row], target);
    }
    
    private boolean binarySearch(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start)/2; 
            if (nums[mid] == target)
                return true;
            else if (nums[mid] > target)
                end = mid-1;
            else
                start = mid + 1;
        }
        return false;
    }
}