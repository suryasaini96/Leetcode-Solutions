class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int res[] = new int[nums.length - k + 1];
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            while (!dq.isEmpty() && dq.peekLast() < nums[end]) {
                dq.removeLast();
            }
            dq.addLast(nums[end]);
            int size = end - start + 1;
            if (size == k) {
                res[start] = dq.peekFirst();
                if (dq.peekFirst() == nums[start]) {
                    dq.removeFirst();
                }
                start++;
            }
        }
        
        return res;
    }
    
    
}