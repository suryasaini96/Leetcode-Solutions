class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
        int erase = 0;
        for (int i = 0; i < intervals.length; i++) {
            while (!stack.isEmpty() && i < intervals.length && stack.peek()[1] > intervals[i][0]) {
                // Remove the interval with longer time
                if (stack.peek()[1] > intervals[i][1]) {
                    stack.pop();
                    erase++;
                    stack.push(intervals[i++]);
                } else {
                    erase++;
                    i++;
                }
            }
            if (i < intervals.length)
                stack.push(intervals[i]);
        }
        return erase;
    }
}