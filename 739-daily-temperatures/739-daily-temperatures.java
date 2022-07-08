class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Exactly same as NGE in stack
        Stack<Integer> stack = new Stack<>();
        int[] days = new int[temperatures.length];
        for (int i = temperatures.length - 1; i>=0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                days[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return days;
    }
}