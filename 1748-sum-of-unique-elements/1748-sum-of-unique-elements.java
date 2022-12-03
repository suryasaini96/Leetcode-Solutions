class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = map.get(nums[i]);
            if (count == 1) {
                sum += nums[i];
            }
        }
        return sum;      
    }
}