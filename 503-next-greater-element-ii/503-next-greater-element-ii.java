class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack<Integer> stack = new Stack<>(); // For keeping elements in ascending order
        
        // Taking loop from 2*n and i%n because of circular condition
        for (int i=2*n-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i%n]) // Keep popping top elements while they are less than nums[i]
                stack.pop();
            
            if (i<n) {
                if (stack.isEmpty())
                    nge[i] = -1;
                else
                    nge[i] = stack.peek();
            }
            
            stack.push(nums[i%n]);
        }
        return nge;
    }
}