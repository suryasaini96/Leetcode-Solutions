class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] previousSmallerElementCount = previousSmallerElementCount(arr);
        int[] nextSmallerElementCount = nextSmallerElementCount(arr);
        
        long res = 0;
        int MOD = (int)(1e9 + 7);
        for (int i = 0; i < arr.length; i++) {
            res = (res + (long)arr[i] * previousSmallerElementCount[i] * nextSmallerElementCount[i]) % MOD;
        }
        return (int) res;
    }
    
    // Count number of elements to the left of number which are greater than number
    private int[] previousSmallerElementCount(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                res[i] = i + 1;
            else
                res[i] = i - stack.peek();
            stack.push(i);
        }
        return res;
    }
    
    // Count number of elements to the right of number which are greater than number
    private int[] nextSmallerElementCount(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = arr.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                res[i] = arr.length - i;
            else
                res[i] = stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}