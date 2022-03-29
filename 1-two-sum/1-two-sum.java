import java.util.Arrays;

class Solution {
    
    // Naive solution: O(n^2) time complexity
    /*
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if (nums[j] == target - nums[i]){
                    return new int [] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two solutions exist.");
    }*/
    
    // Solution 2: Using HashMap O(n) time complexity
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = map.get(target - nums[i]);
                return res;
            } 
            map.put(nums[i], i);
        }
        return res;
    }
}