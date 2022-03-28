class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Maintain 2 values first and second  
        // Basically we check if number 'x' in list is greater than first and second both then its valid triplet 
        
        int first = Integer.MAX_VALUE; 
        int second = Integer.MAX_VALUE;
        
        for (int x: nums) {
            if (x <= first)
                first = x; 
            else if (x > first && x <= second)
                second = x;
            else return true;
        }
        return false;
    }
}