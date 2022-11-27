class Solution {
    
    HashMap<Integer, List<Integer>> map = new HashMap<>();  
    
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            }
        }
    }
    
    public int pick(int target) {
        List<Integer> listOfIndexes = map.get(target);
        int i = (int) (Math.random() * listOfIndexes.size());
        return listOfIndexes.get(i);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */