class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Freq map for mods of sums
        map.put(0, 1); // Put 0 freq as 1
        
        int subArrays = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (mod < 0) mod = mod + k;
            if (map.containsKey(mod)) {
                map.put(mod, map.getOrDefault(mod, 0) + 1);
                subArrays += map.get(mod) - 1;
            } else {
                map.put(mod, 1);
            }
        }
        return subArrays;
    }
}