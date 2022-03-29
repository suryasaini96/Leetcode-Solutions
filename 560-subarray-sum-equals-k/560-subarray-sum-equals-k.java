class Solution {
    
    // Naive approach: Find all the subarrays and check if their sum is equal to k
    
    // Optimized approach: Use HashMap to store prefix sum 
    public int subarraySum(int[] nums, int k) {
        
        // Frequency counter hashmap to store number of occurences of sum
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        
        // Frequency of 0 is 1 as it's not there for empty map
        frequencyMap.put(0, 1);
    
        // Iterate the values and check if sum - k is seen
        int sum = 0; int count = 0;
        for (int x: nums) {
            sum+= x;
            if (frequencyMap.containsKey(sum - k)) {
                count+= frequencyMap.get(sum - k);
            }
            frequencyMap.put(sum, frequencyMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    
    }
}