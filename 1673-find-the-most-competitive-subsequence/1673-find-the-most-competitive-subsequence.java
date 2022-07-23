class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && stack.size() + nums.length - i > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        
        int[] res = new int[k];
        int j = k - 1;
        while (!stack.isEmpty()) {
            res[j--] = stack.pop();
        }
        return res;   
    }
}