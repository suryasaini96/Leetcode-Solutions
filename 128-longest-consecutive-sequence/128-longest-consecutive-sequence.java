class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i]-1)) { // If it is the first element of the sequence
                int len = 1;
                int next = nums[i] + 1;
                while (set.contains(next)) {
                    len++;
                    next++;
                }
                maxLen = Math.max(len, maxLen); // Set max length        
            }
        }
        return maxLen;
    }
}