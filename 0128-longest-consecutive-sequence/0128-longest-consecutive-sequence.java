class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            int x = nums[i];
            if (!set.contains(x + 1)) {
                while (set.contains(x-1)) {
                    len++; x--;
                }
            }
            max = Math.max(len, max);
        }
        return max;
    }
}