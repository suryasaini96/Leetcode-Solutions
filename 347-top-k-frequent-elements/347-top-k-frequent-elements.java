class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        // bucket sort on each element
        List<Integer>[] bucket = new List[nums.length + 1];
        // init the bucket array
        for (int i = 0; i < nums.length + 1; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        
        for (int key: map.keySet()) {
            bucket[map.get(key)].add(key);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length-1; i>=0; i--) {
            res.addAll(bucket[i]);
            if (res.size() == k) break;
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}