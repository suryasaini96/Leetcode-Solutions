class Solution {
    public int minCost(String colors, int[] neededTime) {
        Stack<Integer> stack = new Stack<>();
        int time = 0;
        int n = colors.length();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && i < n && colors.charAt(stack.peek()) == colors.charAt(i)) {
                if (neededTime[stack.peek()] <= neededTime[i]) {
                    time += neededTime[stack.pop()];
                } else {
                    time += neededTime[i++];
                }
            }
            if (i < n)
                stack.push(i);
        }
        return time;
    }
}