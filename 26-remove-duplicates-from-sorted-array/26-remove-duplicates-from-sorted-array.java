class Solution {
    public int removeDuplicates(int[] nums) {
        // approach1: shift the elements after finding a duplicate element
        // this would take O(n^2) time
        
        // approach2: O(n)
        
        int i=0;
        
        for (int j=1; j<nums.length; j++){
            if (nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        
        return i+1;  
    }
}