class Solution {
    // Using dynamic programming for computing leftSmaller and rightSmaller indexes
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int leftSmallerIndex[] = new int[n];
        int rightSmallerIndex[] = new int[n];
        
        leftSmallerIndex[0] = -1;
        rightSmallerIndex[n-1] = n;
        
        // Computing left smaller indexes
        for (int i=1; i<n; i++) {
            int j = i - 1;
            while (j>=0 && heights[j] >= heights[i])
                j = leftSmallerIndex[j];
            leftSmallerIndex[i] = j;
        }
        
        // Computing right smaller indexes
        for (int i=n-2; i>=0; i--) {
            int j = i+1;
            while (j<n && heights[j] >= heights[i])
                j = rightSmallerIndex[j];
            rightSmallerIndex[i] = j;
        }
        
        // Now computing the max rectangle area for each heights[i]
        int max = 0;
        for (int i=0; i<n; i++) {
            int width = rightSmallerIndex[i] - leftSmallerIndex[i] - 1; // -1 because we are dealing in indexes
            int area = width * heights[i];
            if (area > max)
                max = area;
        }
        return max;
    }

//     // Using stack for computing leftSmaller and rightSmaller indexes
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         int leftSmallerIndex[] = new int[n];
//         int rightSmallerIndex[] = new int[n];
        
//         Stack<Integer> stack = new Stack<>();
//         // Computing left smaller indexes
//         for (int i=0; i<n; i++) {
//             while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
//                 stack.pop();
//             if (stack.isEmpty())
//                 leftSmallerIndex[i] = -1;
//             else
//                 leftSmallerIndex[i] = stack.peek();
//             stack.push(i);
//         }
        
//         stack = new Stack<>(); // Re-initialise the stack to re-use
//         // Computing right smaller indexes
//         for (int i=n-1; i>=0; i--) {
//             while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
//                 stack.pop();
//             if (stack.isEmpty())
//                 rightSmallerIndex[i] = n;
//             else
//                 rightSmallerIndex[i] = stack.peek();
//             stack.push(i);
//         }
        
//         // Now computing the max rectangle area for each heights[i]
//         int max = 0;
//         for (int i=0; i<n; i++) {
//             int width = rightSmallerIndex[i] - leftSmallerIndex[i] - 1; // -1 because we are dealing in indexes
//             int area = width * heights[i];
//             if (area > max)
//                 max = area;
//         }
//         return max;
//     }
}