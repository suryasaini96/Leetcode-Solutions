class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0, maxLength = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum += -1;
            } else if (nums[i] == 1) {
                sum += 1;
            }
            if (map.containsKey(sum)) {
                int j = map.get(sum);
                maxLength = Math.max(maxLength, i - j);
            } else {
                map.put(sum, i);
            }
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}