class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int shortest = Integer.MAX_VALUE;
        
        // Calculate running sum of all the elements
        long prefixSum[] = new long[n+1];
        for (int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        
        // Deque to keep track of current indexes
        Deque<Integer> indexes = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            // When the sum exceeds k
            while (!indexes.isEmpty() && prefixSum[i] - prefixSum[indexes.peek()] >= k) {
                shortest = Math.min(shortest, i - indexes.poll());
            }
            
            // Keep the queue in increasing order (monotonic)
            while (!indexes.isEmpty() && prefixSum[i] <= prefixSum[indexes.peekLast()]) {
                indexes.pollLast();
            }
            
            // After all this .. insert the element in the queue
            indexes.add(i);
        }
        
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}