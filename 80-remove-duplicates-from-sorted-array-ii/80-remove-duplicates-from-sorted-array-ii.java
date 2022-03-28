class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int unique_ptr = 1;
        int ptr = 1;
        int count = 1;
        for (int i=1; i<n; i++){
            if (nums[unique_ptr-1] == nums[ptr]){ // duplicate
                if(count!=2){ // not 2 duplicates yet
                    count++;
                    nums[unique_ptr++] = nums[ptr]; 
                } 
            } else { 
                nums[unique_ptr++] = nums[ptr];
                count = 1; // reset the counter
            }  
            ptr++;
        }
        return unique_ptr;
    }
}