class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {            
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                int ele = stack.pop();
                ans += ele * Math.min(stack.peek(), arr[i]);
            }
            stack.push(arr[i]);
        }
        
        while (stack.size() > 2) {
            ans += stack.pop() * stack.peek();
        }
        return ans;
    }
}