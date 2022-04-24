class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int heights[][] = new int[r][c];
        for (int j=0; j<c; j++)
            heights[0][j] = matrix[0][j] == '1' ? 1: 0;
        for (int i=1; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (matrix[i][j] == '0')
                    heights[i][j] = 0;
                else
                    heights[i][j] = heights[i-1][j] + 1;
            }
        }
        
        int maxAreaOfRectangle = 0;
        for (int i=0; i<r; i++) {
            int area = areaOfHistogram(heights[i]);
            if (area > maxAreaOfRectangle)
                maxAreaOfRectangle = area;
        }
        return maxAreaOfRectangle;
    }
    
    private int areaOfHistogram(int heights[]) {
        int n = heights.length;
        int leftLowerIndex[] = new int[n];
        int rightLowerIndex[] = new int[n];
        
        leftLowerIndex[0] = -1;
        rightLowerIndex[n-1] = n;
        // Computing the left lower index
        for (int i=1; i<n; i++) {
            int j = i-1;
            while (j>=0 && heights[j] >= heights[i])
                j = leftLowerIndex[j];
            leftLowerIndex[i] = j;
        }
        // Computing the right lower index
        for (int i=n-2; i>=0; i--) {
            int j = i+1;
            while (j<n && heights[j] >= heights[i])
                j = rightLowerIndex[j];
            rightLowerIndex[i] = j;
        }
        
        // Computing the max area for each heights[i] with calculated width
        int max = 0;
        for (int i=0; i<n; i++) {
            int width = rightLowerIndex[i] - leftLowerIndex[i] - 1; // -1 because we are dealing with indexes
            int area = width * heights[i];
            if (area > max)
                max = area;
        }
        return max;
    }
}