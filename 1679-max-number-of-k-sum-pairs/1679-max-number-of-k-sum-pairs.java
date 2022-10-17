class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int diff = k - nums[i];
            if (map.containsKey(diff)) {
                count++;
                if (map.get(diff) == 1) 
                    map.remove(diff);
                else
                    map.put(diff, map.get(diff) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}