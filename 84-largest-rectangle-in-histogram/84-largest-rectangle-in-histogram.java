class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int leftSmallerIndex[] = new int[n];
        int rightSmallerIndex[] = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        // Computing left smaller indexes
        for (int i=0; i<n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if (stack.isEmpty())
                leftSmallerIndex[i] = -1;
            else
                leftSmallerIndex[i] = stack.peek();
            stack.push(i);
        }
        
        stack = new Stack<>(); // Re-initialise the stack
        // Computing right smaller indexes
        for (int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if (stack.isEmpty())
                rightSmallerIndex[i] = n;
            else
                rightSmallerIndex[i] = stack.peek();
            stack.push(i);
        }
        
        // Now computing the max rectangle width for each heights[i]
        int max = 0;
        for (int i=0; i<n; i++) {
            int width = rightSmallerIndex[i] - leftSmallerIndex[i] - 1; // -1 because we are dealing in indexes
            int area = width * heights[i];
            if (area > max)
                max = area;
        }
        return max;
    }
}