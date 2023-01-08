class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Sum of 0 at index -1
        int sum = 0;
        int prevRightMostIndex = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target) && map.get(sum - target) >= prevRightMostIndex) { // If I have seen sum - target previously
                count++;
                prevRightMostIndex = i;
            }
            map.put(sum, i);
        }
        return count;
    }
}