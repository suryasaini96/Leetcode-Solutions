class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        List<Map<Integer, Integer>> dp = new ArrayList<Map<Integer,Integer>>(n);
        int maxLength = 0;
        for (int i=0; i<n; i++) {
            Map<Integer,Integer> currentMap = new HashMap<>();
            for (int j=0; j<i; j++) {
                Map<Integer,Integer> prevMap = dp.get(j);
                int diff = nums[i] - nums[j];
                int prevCount = prevMap.getOrDefault(diff, 0);
                int newCount = prevCount + 1;
                currentMap.put(diff, newCount);
                maxLength = Math.max(maxLength, newCount);
            }
            dp.add(i, currentMap);
        }
        return maxLength + 1;
    }
}