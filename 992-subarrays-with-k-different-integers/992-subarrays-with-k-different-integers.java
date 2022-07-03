class Solution {
    
    // Approach: Find subarrays with atMost k distinct and atMost k-1 distinct then subtract both
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k-1); // Subtraction will give subarrays with exactly K different elements 
    }
    
    private int atMostKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int subArrays = 0;
        while (end < nums.length) {
            int endNum = nums[end];
            map.put(endNum, map.getOrDefault(endNum, 0) + 1);
            end++;
            
            while (map.size() > k) { // If window size exceeds then remove the starting number a.k.a slide the window
                int startNum = nums[start]; // Get the starting number
                map.put(startNum, map.get(startNum) - 1); // Decrement the count of starting number
                
                if (map.get(startNum) == 0) { // If the starting number has count 0 then remove that number
                    map.remove(startNum);
                }
                start++; // Increment start pointer (slide the window)
            }
            
            subArrays += end - start; // Window size the number of subarrays with at most K elements
        }
        return subArrays;
    }
}